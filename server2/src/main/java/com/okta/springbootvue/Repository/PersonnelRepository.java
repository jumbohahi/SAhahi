package com.okta.springbootvue.Repository;

import com.okta.springbootvue.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
// import org.springframework.web.bind.annotation.CrossOrigin;
// import java.util.Optional;

@RepositoryRestResource
public interface PersonnelRepository extends JpaRepository<Personnel, Long> {
    //  @CrossOrigin(origins = "http://localhost:8080")
    // public interface PositionRepository extends JpaRepository<Position, Long> {
    //     Optional<Position> findById(Long positionId);
    // }
}