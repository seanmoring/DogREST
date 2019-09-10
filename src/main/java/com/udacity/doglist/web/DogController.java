package com.udacity.doglist.web;

import com.udacity.doglist.entity.Dog;
import com.udacity.doglist.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DogController {

    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getDogs() {
        List<Dog> dogList = dogService.retrieveDogs();
        return new ResponseEntity<List<Dog>>(dogList, HttpStatus.OK);
    }

    @GetMapping("/dogs/names")
    public ResponseEntity<List<String>> getNames() {
        List<String> namesList = dogService.retrieveDogNames();

        return new ResponseEntity<List<String>>(namesList, HttpStatus.OK);
    }

    @GetMapping("/dogs/breeds")
    public ResponseEntity<List<String>> getBreeds() {
        List<String> breedList = dogService.retrieveDogBreeds();
        if (breedList.isEmpty())
            return new ResponseEntity<List<String>>(breedList, HttpStatus.NOT_FOUND);

        return new ResponseEntity<List<String>>(breedList, HttpStatus.OK);
    }

    @GetMapping("/dogs/breeds/{id}")
    public ResponseEntity<String> getBreedsById(@PathVariable Long id) {
        String breedByID = dogService.retrieveDogBreedById(id);

        return new ResponseEntity<String>(breedByID, HttpStatus.OK);
    }
}
