package com.okta.springbootvue.DataLoader;

import java.util.stream.Stream;
import com.okta.springbootvue.Entity.*;
import com.okta.springbootvue.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class positionDataloader implements ApplicationRunner {

  
    @Autowired  private PositionRepository positionRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        Stream.of("พยาบาล","หมอ").forEach(positionName -> { 
            Position p = new Position();
            p.setPositionName(positionName);
            positionRepository.save(p);        
        });
             
	}
    
}