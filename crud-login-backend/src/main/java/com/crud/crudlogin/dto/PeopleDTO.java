package com.crud.crudlogin.dto;

import com.crud.crudlogin.entites.People;

public class PeopleDTO {
	
	private Long id;
	private Integer iddepartment;
	private String name;

	public PeopleDTO() {

	}
	
	public PeopleDTO(People entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.iddepartment = entity.getFk_department();
	}

	public PeopleDTO(Long id, String name, Integer iddepartment) {
		this.id = id;
		this.name = name;
		this.iddepartment = iddepartment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIddepartment() {
		return iddepartment;
	}

	public void setIddepartment(final Integer iddepartment) {
		this.iddepartment = iddepartment;
	}
}
