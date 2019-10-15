package com.example.backend.B5900428_Disease.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.stream.Collectors;

import com.example.backend.B5900428_Disease.entity.Type;
import com.example.backend.B5900428_Disease.repository.TypeRepository;

import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TypeController {

    @Autowired
    private final TypeRepository typeRepository;

    public TypeController(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @GetMapping("/type")
    public Collection<Type> type() {
        return typeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/type/{id}")
    public Optional<Type> Type(@PathVariable Long id) {
        Optional<Type> type = typeRepository.findById(id);
        return type;
    }
}