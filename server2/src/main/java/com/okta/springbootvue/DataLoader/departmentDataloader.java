package com.okta.springbootvue.DataLoader;

import java.util.stream.Stream;

import com.okta.springbootvue.Entity.*;
import com.okta.springbootvue.Repository.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class departmentDataloader implements ApplicationRunner {

  
    @Autowired  private DepartmentRepository departmentRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        Stream.of("แผนกผู้ป่วยใน","แผนกผู้ป่วยนอก","แผนกห้องปฏิบัติการทางการแพทย์").forEach(departmentName -> { 
            Department p = new  Department();
            p.setDepartmentName(departmentName);
            departmentRepository.save(p);            
        });


        
        

    

       
        
       
       
	}
    
}