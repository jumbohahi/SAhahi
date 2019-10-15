package com.example.backend.B5923144_infec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Collection;
import java.util.stream.Collectors;

import com.example.backend.B5923144_infec.entity.*;
import com.example.backend.B5923144_infec.repository.*;

import com.example.backend.B5900428_Disease.entity.Disease;
import com.example.backend.B5900428_Disease.repository.DiseaseRepository;

import com.example.backend.B5923403_Personnel.entity.Personnel;
import com.example.backend.B5923403_Personnel.repository.PersonnelRepository;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class PatientController {

    @Autowired
    private final PatientRepository patientRepository;
    @Autowired
    private DiseaseRepository diseaseRepository;
    @Autowired
    private PersonnelRepository personnelRepository;
    @Autowired
    private ProvinceRepository provinceRepository;

    PatientController(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }
    @GetMapping("/pa")
    public Collection<Patient> Patients() {
        return patientRepository.findAll().stream().collect(Collectors.toList());

       
       
    
    }

        @PostMapping("/pa/{name}/{age}/{diseaseid}/{personnelid}/{provinceid}")
        public Patient newPatient(
                                  @PathVariable String name,
                                  @PathVariable int age,
                                  @PathVariable long diseaseid,
                                  @PathVariable long personnelid,
                                  @PathVariable long provinceid) {

            Patient patient = new Patient();
            patient.setName(name);
            patient.setAge(age);

            Disease diseases = diseaseRepository.findById(diseaseid);
            patient.setDisease(diseases);

            Personnel personnels = personnelRepository.findById(personnelid);
            patient.setPersonnel(personnels);

            Province provinces = provinceRepository.findById(provinceid);
            patient.setProvince(provinces);


            return patientRepository.save(patient);
        }


}