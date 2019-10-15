package com.example.backend.B5900428_Disease.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;



import com.example.backend.B5900428_Disease.entity.Disease;
import com.example.backend.B5923403_Personnel.entity.Personnel;
import com.example.backend.B5900428_Disease.entity.Rate;
import com.example.backend.B5900428_Disease.entity.Symptom;
import com.example.backend.B5900428_Disease.entity.Type;

import com.example.backend.B5900428_Disease.repository.DiseaseRepository;
import com.example.backend.B5923403_Personnel.repository.*;
import com.example.backend.B5900428_Disease.repository.RateRepository;
import com.example.backend.B5900428_Disease.repository.TypeRepository;
import com.example.backend.B5900428_Disease.repository.SymptomRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "http://localhost:8080")

class DiseaseController {
    @Autowired
    private final DiseaseRepository diseaseRepository;

    @Autowired
    private RateRepository rateRepository;

    @Autowired
    private SymptomRepository symptomRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private PersonnelRepository personnelRepository;


    DiseaseController(DiseaseRepository diseaseRepository){
        this.diseaseRepository = diseaseRepository;
    }


    @GetMapping("/disease")
    public Collection<Disease> Disease() {
        return diseaseRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/Disease/{diseasename}/{personnelid}/{typeid}/{symptomid}/{rateid}")
        public Disease newDisease(Disease newDisease,
                                  @PathVariable String diseasename,
                                  @PathVariable long personnelid,
                                  @PathVariable long typeid,
                                  @PathVariable long symptomid,
                                  @PathVariable long rateid) {
                                      
          
            Personnel personnel = personnelRepository.findById(personnelid);
            Type type = typeRepository.findById(typeid);
            Rate rate = rateRepository.findById(rateid);
            Symptom symptom = symptomRepository.findById(symptomid);

            newDisease.setDiseaseName(diseasename);
            newDisease.setPersonnel(personnel);
            newDisease.setType(type);
            newDisease.setSymptom(symptom);
            newDisease.setRate(rate);
            

            
            return diseaseRepository.save(newDisease);

    }
}