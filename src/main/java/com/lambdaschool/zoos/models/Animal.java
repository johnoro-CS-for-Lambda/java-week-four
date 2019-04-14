package com.lambdaschool.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "animals")
public class Animal {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "animal_id")
  private long id;

  private String type;

  @ManyToMany(cascade = CascadeType.ALL,
    mappedBy = "animals", fetch = FetchType.EAGER
  )
  @JsonIgnoreProperties("animals")
  private Set<Zoo> zoos;

  public Animal() {}

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Set<Zoo> getZoos() {
    return zoos;
  }

  public void setZoos(Set<Zoo> zoos) {
    this.zoos = zoos;
  }
}
