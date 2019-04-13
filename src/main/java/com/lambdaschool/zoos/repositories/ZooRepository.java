package com.lambdaschool.zoos.repositories;

import com.lambdaschool.zoos.models.Zoo;

public interface ZooRepository extends BaseRepository<Zoo> {
  Zoo findByName(String name);
}
