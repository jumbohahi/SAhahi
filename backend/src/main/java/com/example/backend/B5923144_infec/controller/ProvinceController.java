package com.example.backend.B5923144_infec.controller; 

import com.example.backend.B5923144_infec.entity.Province;
import com.example.backend.B5923144_infec.repository.ProvinceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ProvinceController {

    @Autowired
    private final ProvinceRepository provinceRepository;

    public ProvinceController(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }
    @GetMapping("/pro")
    public Collection<Province> Provinces() {
        return provinceRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/pro/{id}")
    public Optional<Province> Provinces(@PathVariable Long id) {
        Optional<Province> province = provinceRepository.findById(id);
        return province;
    }
}
