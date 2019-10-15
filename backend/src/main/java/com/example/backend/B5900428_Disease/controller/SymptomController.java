package com.example.backend.B5900428_Disease.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.stream.Collectors;

import com.example.backend.B5900428_Disease.entity.Symptom;
import com.example.backend.B5900428_Disease.repository.SymptomRepository;

import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class SymptomController {

    @Autowired
    private final SymptomRepository symptomRepository;

    public SymptomController(SymptomRepository symptomRepository) {
        this.symptomRepository = symptomRepository;
    }

    @GetMapping("/symptom")
    public Collection<Symptom> symptom() {
        return symptomRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/symptom/{id}")
    public Optional<Symptom> Symptom(@PathVariable Long id) {
        Optional<Symptom> symptom = symptomRepository.findById(id);
        return symptom;
    }
}