package com.crud.crudlogin.entites;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tasks")
public class RecordTasks {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String titulo;

  private String description;
  private Integer fk_department;
  private Integer duration;
  private Integer fk_pessoa;
  private Boolean finish;

  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Date date;

  @ManyToMany
  @JoinTable(name = "tb_tasks_people", joinColumns = @JoinColumn(name = "tasks_id"), inverseJoinColumns = @JoinColumn(name = "people_id"))

  //Tipo da coleção categoria sabe automatico o que é pelo JPA
  Set<People> categories = new HashSet<>(); //Mesmo produto n pode ter a mesma categoria por isso usei o SET,

  public RecordTasks() {
  }

  public RecordTasks(Long id, String titulo, String description, Date date, Integer fk_department,
      Integer duration, Integer fk_pessoa, Boolean finish) {
    super();
    this.id = id;
    this.titulo = titulo;
    this.description = description;
    this.date = date;
    this.fk_department = fk_department;
    this.duration = duration;
    this.fk_pessoa = fk_pessoa;
    this.finish = finish;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getPrice() {
    return fk_department;
  }

  public void setPrice(Integer idDepartmant) {
    this.fk_department = idDepartmant;
  }

  public Boolean getImgUrl() {
    return finish;
  }

  public void setImgUrl(Boolean imgUrl) {
    this.finish = imgUrl;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Set<People> getCategories() {
    return categories;
  }

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(final Integer duration) {
    this.duration = duration;
  }

  public Integer getIdPessoa() {
    return fk_pessoa;
  }

  public void setIdPessoa(final Integer idPessoa) {
    this.fk_pessoa = idPessoa;
  }

  public Boolean getFinish() {
    return finish;
  }

  public void setFinish(final Boolean finish) {
    this.finish = finish;
  }

}
