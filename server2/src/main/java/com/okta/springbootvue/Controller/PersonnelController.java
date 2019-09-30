package com.okta.springbootvue.Controller;

import com.okta.springbootvue.Entity.*;
import com.okta.springbootvue.Repository.*;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
class PersonnelController {
    @Autowired  private PersonnelRepository personnelRepository;
    @Autowired  private PrefixRepository prefixRepository;
    @Autowired  private PositionRepository positionRepository;
    @Autowired  private DepartmentRepository departmentRepository;
    
    // @Autowired RoleRepository roleRepository;


    @GetMapping("/Personnels")
    public List<Personnel> getPersonnel() {
        return personnelRepository.findAll();
    }

    @PostMapping("/Personnels/add")
    public Personnel addPersonnel(@RequestBody() Map<String, String> body) {
        Personnel newPersonnel = new Personnel();
        Optional<Prefix> prefix = prefixRepository.findById(Long.valueOf(body.get("prefix").toString()));
        Optional<Position> position = positionRepository.findById(Long.valueOf(body.get("position").toString()));
        Optional<Department> department = departmentRepository.findById(Long.valueOf(body.get("department").toString()));
        
        // Optional<Role> role = roleRepository.findById(Long.valueOf(body.get("Role").toString()));
        newPersonnel.setPrefix(prefix.get());
        newPersonnel.setPersonnelName(body.get("personnelName").toString());
        newPersonnel.setPosition(position.get());
        newPersonnel.setDepartment(department.get());
        newPersonnel.setPersonnelRole(body.get("personnelRole").toString());

        return personnelRepository.save(newPersonnel);

    }
}


