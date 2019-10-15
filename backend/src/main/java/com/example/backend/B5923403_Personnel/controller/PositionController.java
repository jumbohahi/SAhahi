package com.example.backend.B5923403_Personnel.controller;

import com.example.backend.B5923403_Personnel.entity.Position;
import com.example.backend.B5923403_Personnel.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PositionController {
    @Autowired
    private final PositionRepository positionRepository;

    public PositionController(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }
    @GetMapping("/position")
    public Collection<Position> positions(){return positionRepository.findAll().stream().collect(Collectors.toList());}
}
