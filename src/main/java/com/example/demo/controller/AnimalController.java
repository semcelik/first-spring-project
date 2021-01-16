package com.example.demo.controller;

import com.example.demo.Animal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class AnimalController {

    private final AtomicInteger counter = new AtomicInteger();

    @GetMapping("animals")
    public Animal getAll() {
        return getAnimal();
    }

    private Animal getAnimal() {
        Animal animal = new Animal();
        animal.setId(counter.incrementAndGet());
        animal.setName("animal-2");

        return animal;
    }
}