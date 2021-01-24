package com.example.demo.controller;

import com.example.demo.entity.Animal;
import com.example.demo.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping("/")
    public String root() {
        return "hello-amazon v0.0.80";
    }

    @GetMapping("animals")
    public List<Animal> getAll() {
        List<Animal> animals = (List<Animal>) animalRepository.findAll();
        Collections.reverse(animals);
        return animals;
    }

    @GetMapping("animals/{name}")
    public Animal save(@PathVariable String name) {
        Animal animal = new Animal();
        animal.setName(name);
        animal.setStatus(1);
        Animal savedAnimal = animalRepository.save(animal);
        return savedAnimal;
    }
}
