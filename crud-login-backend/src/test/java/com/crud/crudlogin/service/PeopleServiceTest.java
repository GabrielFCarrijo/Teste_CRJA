package com.crud.crudlogin.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.crud.crudlogin.dto.PeopleDTO;
import com.crud.crudlogin.entites.People;
import com.crud.crudlogin.repositories.RecordRepository;
import com.crud.crudlogin.service.exceptions.ResourceNotFoundException;
import com.github.javafaker.Faker;

@ExtendWith(MockitoExtension.class)
class PeopleServiceTest {

  private final Faker faker = new Faker();

  @Mock
  private RecordRepository recordRepository;

  @InjectMocks
  private RecordService recordService;

  @Test
  void givenIdWhenCallFindByIdThenReturnCategoryDto() {
    //given
    final var id = faker.number().numberBetween(1L, 10L);
    final var name = faker.name().firstName();
    final var category = new People();
    category.setId(id);
    category.setName(name);

    //when
    Mockito.when(recordRepository.findById(id)).thenReturn(Optional.of(category));
    PeopleDTO dto = recordService.findById(id);

    //then
    assertThat(dto.getId()).isEqualTo(category.getId());
    assertThat(dto.getName()).isEqualTo(category.getName());
  }

  @Test
  void givenIdWhenCallFindByIdThenThrowResourceNotFoundException() {
    //given
    final var id = faker.number().numberBetween(1L, 10L);

    //when - then
    Mockito.when(recordRepository.findById(id)).thenReturn(Optional.empty());
    assertThatThrownBy(() -> recordService.findById(id))
        .isInstanceOf(ResourceNotFoundException.class)
        .hasMessage("Erro Interno do Servidor");
  }

  @Test
  void givenCategoryDtoWhen() {

    //given
    final var dto = new PeopleDTO();
    final var entity = new People();
    final var persistedEntity = new People();
    final var name = faker.name().firstName();
    final var id = faker.number().numberBetween(1L, 10L); // Volta do banco para validação

    persistedEntity.setName(name);
    persistedEntity.setId(id);

    entity.setName(name);
    dto.setName(name);

    //when
    Mockito.when(recordRepository.save(entity)).thenReturn(persistedEntity);
    PeopleDTO peopleDTO = recordService.insert(dto);

    //then
    assertThat(peopleDTO.getId()).isEqualTo(persistedEntity.getId());
    assertThat(peopleDTO.getName()).isEqualTo(persistedEntity.getName());
  }

}
