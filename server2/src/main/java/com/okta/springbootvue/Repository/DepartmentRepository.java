package com.okta.springbootvue.Repository;

import com.okta.springbootvue.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource
public interface DepartmentRepository extends JpaRepository<Department, Long> {
   
}