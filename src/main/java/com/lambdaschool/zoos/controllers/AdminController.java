package com.lambdaschool.zoos.controllers;

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

  // TODO implement required post, put, and delete routes
}
