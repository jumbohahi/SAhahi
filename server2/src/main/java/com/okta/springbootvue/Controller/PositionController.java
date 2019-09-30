package com.okta.springbootvue.Controller;

import com.okta.springbootvue.Entity.*;
import com.okta.springbootvue.Repository.*;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class PositionController{
    @Autowired private PositionRepository positionRepository;

    @GetMapping("/Positions")
    public List<Position> getPosition() {
        return positionRepository.findAll();
    }

    @PostMapping("/Positions/add")
    public Position addPosition(@RequestBody() Map<String, Object> body) {
        Position newPosition = new Position();
        newPosition.setPositionName(body.get("positionName").toString());
        return positionRepository.save(newPosition);
    }

    
}