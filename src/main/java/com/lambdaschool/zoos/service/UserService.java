package com.lambdaschool.zoos.service;

import com.lambdaschool.zoos.models.User;

import java.util.List;

public interface UserService {
  User save(User user);

  List<User> findAll();

  void delete(long id);
}
