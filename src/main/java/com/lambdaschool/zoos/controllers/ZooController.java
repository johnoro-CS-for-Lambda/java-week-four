package com.lambdaschool.zoos.controllers;

import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "zoos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ZooController {
  @Autowired
  ZooRepository repository;

  @GetMapping
  public List<Zoo> findAll() {
    return repository.findAll();
  }
}
