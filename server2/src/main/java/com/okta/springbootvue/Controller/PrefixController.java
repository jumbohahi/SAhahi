package com.okta.springbootvue.Controller;

import com.okta.springbootvue.Entity.*;
import com.okta.springbootvue.Repository.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
// @RequestMapping("/Prefix")
class PrefixController{
    @Autowired
    private PrefixRepository prefixRepository;


    @GetMapping("/Prefix")
    public List<Prefix> getprefix() {
        return prefixRepository.findAll();
    }


}