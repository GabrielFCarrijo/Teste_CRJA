package com.crud.crudlogin.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.crud.crudlogin.dto.PeopleDTO;
import com.crud.crudlogin.service.RecordService;

@RestController // Configurar coisas no codigo
@RequestMapping(value = "/people")
public class RecordResources {
	
	@Autowired
	private RecordService service;
	
	@GetMapping
	public ResponseEntity<Page<PeopleDTO>> catchAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy
			){
			PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
				
		Page<PeopleDTO> list = service.catchAllPaged(pageRequest);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<PeopleDTO> findById(@PathVariable Long id){
		PeopleDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<PeopleDTO> insert(@RequestBody PeopleDTO peopleDTO){
		peopleDTO = service.insert(peopleDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(peopleDTO.getId()).toUri(); // Estrutura para inserir um objeto e responder da forma correta
		
		return ResponseEntity.created(uri).body(peopleDTO);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PeopleDTO> update(@PathVariable Long id, @RequestBody PeopleDTO peopleDTO){
		peopleDTO = service.update(id , peopleDTO);
		return ResponseEntity.ok().body(peopleDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();	
	}
		
}