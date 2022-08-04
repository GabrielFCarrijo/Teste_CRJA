package com.crud.crudlogin.entites;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "tb_people")
public class People {
	
	@Id //Conversar com jpa para ser ID auto encrementavel
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer fk_department;
	private String name;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant created_At;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updated_At;



	public People() {
	}

	public People(Long id, String name, Integer fk_department) {
		this.id = id;
		this.name = name;
		this.fk_department = fk_department;
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

	public Integer getFk_department() {
		return fk_department;
	}

	public void setFk_department(final Integer fk_department) {
		this.fk_department = fk_department;
	}

	public Instant getCreateAt() {
		return created_At;
	}

	public Instant getUpdatedAt() {
		return updated_At;
	}

	@PrePersist
	public void prePersist() {
		created_At = Instant.now();
	}

	@PreUpdate
	public void preUpdate() {
		updated_At = Instant.now();
	}

	@Override
	public int hashCode() { // Método padrão para comparação de numeros iguais
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) { // Comparação de objetos
		if(this == obj)
		    return true;
		if (obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		People other = (People) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		}else if (!id.equals(other.id))
			return false;
		return true;
	}
}
