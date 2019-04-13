package com.lambdaschool.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "zoos")
public class Zoo {
  @Id
  @GeneratedValue
  @Column(name = "zoo_id")
  private long id;

  private String name;

  @OneToMany(mappedBy = "zoo")
  @JsonIgnoreProperties("zoo")
  private Set<Telephone> telephones;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "zoos_join_animals",
    joinColumns = { @JoinColumn(name="zoo_id") },
    inverseJoinColumns = { @JoinColumn(name="animal_id") }
  )
  @JsonIgnoreProperties("zoos")
  private Set<Animal> animals;

  public Zoo() {}

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Telephone> getTelephones() {
    return telephones;
  }

  public void setTelephones(Set<Telephone> telephones) {
    this.telephones = telephones;
  }

  public Set<Animal> getAnimals() {
    return animals;
  }

  public void setAnimals(Set<Animal> animals) {
    this.animals = animals;
  }
}
