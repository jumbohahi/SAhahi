package com.example.backend.B5923403_Personnel.repository;

import com.example.backend.B5923403_Personnel.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findById(long departmentId);
}
