package com.crud.crudlogin.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.crudlogin.dto.PeopleDTO;
import com.crud.crudlogin.entites.People;
import com.crud.crudlogin.repositories.RecordRepository;
import com.crud.crudlogin.service.exceptions.DataBaseException;
import com.crud.crudlogin.service.exceptions.ResourceNotFoundException;

@Service  // Registrar a classe como componente que participa do sistema de injeção de dependencia
public class RecordService {

	@Autowired
	private RecordRepository repository;
	
	@Transactional(readOnly = true) //
	public Page<PeopleDTO> catchAllPaged(final PageRequest pageRequest){
		
		Page<People> list = repository.findAll(pageRequest);
		return list.map(x -> new PeopleDTO(x));//Transformando list category em lisDTO
		
	}

	@Transactional(readOnly = true)
	public PeopleDTO findById(final Long id) {
		Optional<People> obj = repository.findById(id);//Efetiva o acesso ao banco de dados
		People entity = obj.orElseThrow(() -> new ResourceNotFoundException("Erro Interno do Servidor"));// Leva para minha nova exception
		return new PeopleDTO(entity);
	}
	
	@Transactional
	public PeopleDTO insert(PeopleDTO peopleDTO) {
		People entity = new People();
		entity.setFk_department(peopleDTO.getIddepartment());
		entity.setName(peopleDTO.getName());
		entity.setFk_department(peopleDTO.getIddepartment());
		entity = repository.save(entity); // cria uma nova entidade no banco
		return new PeopleDTO(entity);
	}

	@Transactional
	public PeopleDTO update(Long id, PeopleDTO peopleDTO) {
	//Não mexe no banco e instancia um objeto provisorio com dados e o ID no objeto apenas quando salva ele vai no banco
		try{
		People entity = repository.getOne(id);
			entity.setName(peopleDTO.getName());
			entity.setFk_department(peopleDTO.getIddepartment());
			entity = repository.save(entity);
		return new PeopleDTO(entity);
		}
		catch(EntityNotFoundException entityNotFoundException){
			throw new ResourceNotFoundException("ID não encontrado"+ id);
		}
	}

	public void delete(Long id) {
		try {
		repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException emptyResultDataAccessException) { //Caso tentem deletar um id que n existe
			throw new ResourceNotFoundException("ID "+ id + " não encontrado!");
		}
		catch(DataIntegrityViolationException dataIntegrityViolationException) { //Caso tentem deletar algo que n pode
			throw new DataBaseException("Violação de Integridade");
		}
	}
}

