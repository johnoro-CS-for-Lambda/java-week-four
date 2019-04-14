package com.lambdaschool.zoos.controllers;

import com.lambdaschool.zoos.models.Animal;
import com.lambdaschool.zoos.models.Telephone;
import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.repositories.AnimalRepository;
import com.lambdaschool.zoos.repositories.TelephoneRepository;
import com.lambdaschool.zoos.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {
  @Autowired
  AnimalRepository animalRepository;

  @Autowired
  ZooRepository zooRepository;

  @Autowired
  TelephoneRepository telephoneRepository;

  @PutMapping(value = "zoos/{id}")
  public Zoo updateZoo(@RequestBody Zoo newZoo, @PathVariable("id") long id) {
    var foundZoo = zooRepository.findById(id);
    if (foundZoo.isPresent()) {
      Zoo zoo = foundZoo.get();
      if (newZoo.getName() == null) {
        newZoo.setName(zoo.getName());
      }
      if (newZoo.getTelephones() == null) {
        newZoo.setTelephones(zoo.getTelephones());
      }
      if (newZoo.getAnimals() == null) {
        newZoo.setAnimals(zoo.getAnimals());
      }
      newZoo.setId(id);
      zooRepository.save(newZoo);
      return newZoo;
    }

    return null;
  }

  @PostMapping(value = "zoos")
  public Zoo addZoo(@RequestBody Zoo newZoo) {
    Zoo zoo = zooRepository.save(newZoo);
    return zoo;
  }

  @DeleteMapping(value = "zoos/{id}")
  public Zoo deleteZoo(@PathVariable("id") long id) {
    var foundZoo = zooRepository.findById(id);

    if (foundZoo.isPresent()) {
      Zoo zoo = foundZoo.get();

      zooRepository.deleteTelephones(id);
      zooRepository.deleteZooJoinAnimal(id);
      zooRepository.deleteById(id);

      return zoo;
    }

    return null;
  }

  @PutMapping(value = "telephones/{id}")
  public Telephone updateTelephone(@RequestBody Telephone newTelephone, @PathVariable("id") long id) {
    var foundTelephone = telephoneRepository.findById(id);
    if (foundTelephone.isPresent()) {
      Telephone telephone = foundTelephone.get();

      if (newTelephone.getType() == null) {
        newTelephone.setType(telephone.getType());
      }
      if (newTelephone.getNumber() == null) {
        newTelephone.setNumber(telephone.getNumber());
      }
      if (newTelephone.getZoo() == null) {
        newTelephone.setZoo(telephone.getZoo());
      }

      newTelephone.setId(id);
      telephoneRepository.save(newTelephone);
      return newTelephone;
    }

    return null;
  }

  @PostMapping(value = "telephones")
  public Telephone addTelephone(@RequestBody Telephone newTelephone) {
    Telephone telephone = telephoneRepository.save(newTelephone);
    return telephone;
  }

  @DeleteMapping(value = "telephones/{id}")
  public Telephone deleteTelephone(@PathVariable("id") long id) {
    var foundTelephone = telephoneRepository.findById(id);

    if (foundTelephone.isPresent()) {
      Telephone telephone = foundTelephone.get();

      telephoneRepository.deleteById(id);

      return telephone;
    }

    return null;
  }

  @PutMapping(value = "animals/{id}")
  public Animal updateAnimal(@RequestBody Animal newAnimal, @PathVariable("id") long id) {
    var foundAnimal = animalRepository.findById(id);

    if (foundAnimal.isPresent()) {
      Animal animal = foundAnimal.get();
      if (newAnimal.getType() == null) {
        newAnimal.setType(animal.getType());
      }
      if (newAnimal.getZoos() == null) {
        newAnimal.setZoos(animal.getZoos());
      }
      newAnimal.setId(id);
      animalRepository.save(newAnimal);
      return newAnimal;
    }

    return null;
  }

  @PostMapping(value = "animals")
  public Animal addAnimal(@RequestBody Animal newAnimal) {
    Animal animal = animalRepository.save(newAnimal);
    return animal;
  }

  @DeleteMapping(value = "animals/{id}")
  public Animal deleteAnimal(@PathVariable("id") long id) {
    var foundAnimal = animalRepository.findById(id);

    if (foundAnimal.isPresent()) {
      Animal animal = foundAnimal.get();

      animalRepository.deleteZooJoinAnimal(id);
      animalRepository.deleteById(id);

      return animal;
    }

    return null;
  }
}
