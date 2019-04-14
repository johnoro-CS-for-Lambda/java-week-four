package com.lambdaschool.zoos.repositories;

import com.lambdaschool.zoos.models.Animal;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface AnimalRepository extends BaseRepository<Animal> {
  Animal findByType(String type);

  @Transactional
  @Modifying
  @Query(value = "DELETE FROM zoos_join_animals " +
    "WHERE animal_id = :id", nativeQuery = true)
  void deleteZoosAnimal(long id);
}
