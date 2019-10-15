package com.example.backend.B5923403_Personnel.controller;
import com.example.backend.B5923403_Personnel.entity.Department;
import com.example.backend.B5923403_Personnel.entity.Personnel;
import com.example.backend.B5923403_Personnel.entity.Position;
import com.example.backend.B5923403_Personnel.entity.Prefix;
import com.example.backend.B5923403_Personnel.repository.DepartmentRepository;
import com.example.backend.B5923403_Personnel.repository.PersonnelRepository;
import com.example.backend.B5923403_Personnel.repository.PositionRepository;
import com.example.backend.B5923403_Personnel.repository.PrefixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
public class PersonnelController {
    @Autowired
    private final PersonnelRepository personnelRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private PrefixRepository prefixRepository;

    public PersonnelController(PersonnelRepository personnelRepository) {
        this.personnelRepository = personnelRepository;
    }

    @GetMapping("/personnel")
    public Collection<Personnel> personnels() {
        return personnelRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/personnel/{prefix_id}/{position_id}/{department_id}")
    public Personnel newPersonnel(@RequestBody Personnel personnel,
                                  @PathVariable long prefix_id,
                                  @PathVariable long position_id,
                                  @PathVariable long department_id) {

        Department department = departmentRepository.findById(department_id);
        Position position = positionRepository.findById(position_id);
        Prefix prefix = prefixRepository.findById(prefix_id);

        Personnel newPersonnel = new Personnel();
        newPersonnel.setPersonnelName(personnel.getPersonnelName());
        newPersonnel.setPersonnelRole(personnel.getPersonnelRole());
        newPersonnel.setDepartment(department);
        newPersonnel.setPosition(position);
        newPersonnel.setPrefix(prefix);
        return personnelRepository.save(newPersonnel);
    }
}
