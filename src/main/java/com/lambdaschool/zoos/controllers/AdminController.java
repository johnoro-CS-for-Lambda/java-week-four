package com.lambdaschool.zoos.controllers;

@RestController
@RequestMapping(value = "admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {
  @Autowired
  AnimalRepository animalRepository;

  @Autowired
  ZooRepository zooRepository;

  @Autowired
  TelephoneRepository telephoneRepository;

  // TODO implement required post, put, and delete routes
}
