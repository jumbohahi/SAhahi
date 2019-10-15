package com.example.backend.B5900428_Disease.repository;

import  com.example.backend.B5900428_Disease.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface TypeRepository extends JpaRepository<Type, Long> {
    Type findById(long typeid);
}