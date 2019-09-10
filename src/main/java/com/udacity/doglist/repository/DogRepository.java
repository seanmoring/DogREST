package com.udacity.doglist.repository;

import com.udacity.doglist.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}
