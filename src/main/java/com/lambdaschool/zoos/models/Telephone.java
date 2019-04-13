package com.lambdaschool.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "telephones")
public class Telephone {
  @Id
  @GeneratedValue
  @Column(name = "telephone_id")
  private long id;

  private String type;

  private String number;

  @ManyToOne
  @JoinColumn(name = "zoo_id")
  @JsonIgnoreProperties("telephones")
  private Zoo zoo;

  public Telephone() {}

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

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Zoo getZoo() {
    return zoo;
  }

  public void setZoo(Zoo zoo) {
    this.zoo = zoo;
  }
}
