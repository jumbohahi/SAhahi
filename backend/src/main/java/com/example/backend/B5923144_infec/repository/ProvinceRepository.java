package com.example.backend.B5923144_infec.repository;

import com.example.backend.B5923144_infec.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:8080")
public interface ProvinceRepository extends JpaRepository <Province, Long>{
    Province findById(long provinceid);
}
