package com.example.backend.B5923403_Personnel.controller;

import com.example.backend.B5923403_Personnel.entity.Prefix;
import com.example.backend.B5923403_Personnel.repository.PrefixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PrefixController {
    @Autowired
    private final PrefixRepository prefixRepository;

    public PrefixController(PrefixRepository prefixRepository) {
        this.prefixRepository = prefixRepository;
    }
    @GetMapping("/prefix")
    public Collection<Prefix> prefixes(){return prefixRepository.findAll().stream().collect(Collectors.toList());}
}
