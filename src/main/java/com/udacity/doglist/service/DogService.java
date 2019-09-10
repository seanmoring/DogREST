package com.udacity.doglist.service;

import com.udacity.doglist.entity.Dog;
import com.udacity.doglist.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class DogService {

    @Autowired
    DogRepository dogRepository;

    public List<Dog> retrieveDogs() {
        List<Dog> dogs = new ArrayList<>();
        Iterator<Dog> it = dogRepository.findAll().iterator();

        while (it.hasNext()) {
            Dog dog = it.next();
            dogs.add(dog);
        }
        return dogs;
    }

    public List<String> retrieveDogBreeds() {
        List<String> breeds = new ArrayList<>();
        Iterator<Dog> it = dogRepository.findAll().iterator();

        while (it.hasNext()) {
            String breed = it.next().getBreed();
            if (!breeds.contains(breed)) breeds.add(breed);
        }
        return breeds;
    }

    public String retrieveDogBreedById(Long id) {
        Optional<Dog> dog = dogRepository.findById(id);

        if (dog.isPresent())
            return dog.get().getBreed();
        else
            throw new DogNotFoundException();
    }

    public List<String> retrieveDogNames() {
        List<String> names = new ArrayList<>();
        Iterator<Dog> it = dogRepository.findAll().iterator();

        while (it.hasNext()) {
            String name = it.next().getName();
            names.add(name);
        }
        return names;
    }
}
