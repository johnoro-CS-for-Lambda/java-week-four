package com.lambdaschool.zoos.repositories;

import com.lambdaschool.zoos.models.Zoo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface ZooRepository extends BaseRepository<Zoo> {
  Zoo findByName(String name);

  @Transactional
  @Modifying
  @Query(value = "DELETE FROM telephones " +
    "WHERE zoo_id = :id", nativeQuery = true)
  void deleteTelephones(long id);

  @Transactional
  @Modifying
  @Query(value = "DELETE FROM zoos_join_animals " +
    "WHERE zoo_id = :id", nativeQuery = true)
  void deleteZooJoinAnimal(long id);

  @Transactional
  @Modifying
  @Query(value = "INSERT INTO zoos_join_animals (zoo_id, animal_id)" +
    "VALUES(:zooId, :animalId)", nativeQuery = true)
  void addZooJoinAnimal(long zooId, long animalId);
}
