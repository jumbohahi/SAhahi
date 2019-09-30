package com.okta.springbootvue.DataLoader;

import java.util.stream.Stream;
import com.okta.springbootvue.Entity.*;
import com.okta.springbootvue.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class prefixDataloader implements ApplicationRunner {

  
    @Autowired  private PrefixRepository prefixRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        Stream.of("นาย","นาง","นางสาว").forEach(prefixName -> { 
            Prefix p = new Prefix();
            p.setPrefixName(prefixName);
            prefixRepository.save(p);            
        });


        
        

    

       
        
       
       
	}
    
}