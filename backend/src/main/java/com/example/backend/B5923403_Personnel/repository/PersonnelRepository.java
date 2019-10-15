package com.example.backend.B5923403_Personnel.repository;

import com.example.backend.B5923403_Personnel.entity.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonnelRepository extends JpaRepository<Personnel, Long> {
    Personnel  findById(long personnelId);
}
