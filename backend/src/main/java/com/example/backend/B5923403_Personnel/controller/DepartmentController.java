package com.example.backend.B5923403_Personnel.controller;

import com.example.backend.B5923403_Personnel.entity.Department;
import com.example.backend.B5923403_Personnel.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class DepartmentController {
    @Autowired
    private final DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    @GetMapping("/department")
    public Collection<Department> departments(){
        return departmentRepository.findAll().stream().collect(Collectors.toList());}
}
