package com.example.backend.B5902200_ExamResult.Controller;                      //กำลังบอกว่า package นี้ เป็นของ Controller
import com.example.backend.B5902200_ExamResult.Repository.*;
import com.example.backend.B5902200_ExamResult.Entity.*;                    //import repo ทุกอันมาไว้ในนี้
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;
@RestController                                 //บังคับให้ class นี้เป็น Controller
@CrossOrigin(origins = "http://localhost:8080") //ทำให้ spingboot , vue ส่งข้อมูหากันได้
class PeriodController{                         //บอกตำแหน่งปัจจุบัน
    
    @Autowired                                          
    private PeriodRepository periodRepository;     

    public PeriodController(PeriodRepository periodRepository) {
        this.periodRepository = periodRepository;
    }

    @GetMapping("/period")                           
    public Collection<Period> Periods(){                  
        return periodRepository.findAll().stream().collect(Collectors.toList());
     
    }

    @GetMapping("/period/{id}")
    public Optional<Period> Periods(@PathVariable Long id) {
        Optional<Period> period = periodRepository.findById(id);
        return period;
    }
}