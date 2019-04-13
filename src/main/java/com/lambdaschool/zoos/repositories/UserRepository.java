package com.lambdaschool.zoos.repositories;

import com.lambdaschool.zoos.models.User;

public interface UserRepository extends BaseRepository<User> {
  User findByName(String name);
}
