package com.crud.crudlogin.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_department")
public class Department {

  @Id //Conversar com jpa para ser ID auto encrementavel
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String titulo;

  public Department() {
  }

  public Department(final Long id, final String titulo) {
    this.id = id;
    this.titulo = titulo;
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getDepartment() {
    return titulo;
  }

  public void setDepartment(final String titulo) {
    this.titulo = titulo;
  }
}
