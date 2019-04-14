package com.lambdaschool.zoos.models.transactional;

public class ZooJoinAnimal {
  private long zooId;
  private long animalId;

  public ZooJoinAnimal(long zooId, long animalId) {
    this.zooId = zooId;
    this.animalId = animalId;
  }

  public long getZooId() {
    return zooId;
  }

  public void setZooId(long zooId) {
    this.zooId = zooId;
  }

  public long getAnimalId() {
    return animalId;
  }

  public void setAnimalId(long animalId) {
    this.animalId = animalId;
  }
}
