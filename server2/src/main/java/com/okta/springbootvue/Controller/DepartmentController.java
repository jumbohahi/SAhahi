package com.okta.springbootvue.Controller;

import com.okta.springbootvue.Entity.*;
import com.okta.springbootvue.Repository.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
// import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
// @RequestMapping("/Area")
class DepartmentController{
    @Autowired
    private  DepartmentRepository  departmentRepository;

    @GetMapping("/Department")
    public List< Department>  Department(){
        return  departmentRepository.findAll().stream().collect(Collectors.toList());
    
    }


}