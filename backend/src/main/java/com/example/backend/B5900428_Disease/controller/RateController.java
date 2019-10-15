package com.example.backend.B5900428_Disease.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.stream.Collectors;

import com.example.backend.B5900428_Disease.entity.Rate;
import com.example.backend.B5900428_Disease.repository.RateRepository;

import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class RateController {

    @Autowired
    private final RateRepository rateRepository;

    public RateController(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    @GetMapping("/rate")
    public Collection<Rate> rate() {
        return rateRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/rate/{id}")
    public Optional<Rate> Durations(@PathVariable Long id) {
        Optional<Rate> rate = rateRepository.findById(id);
        return rate;
    }
}