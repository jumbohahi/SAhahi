package com.example.backend.B5900428_Disease.repository;

import  com.example.backend.B5900428_Disease.entity.Rate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface RateRepository extends JpaRepository<Rate, Long> {
    Rate findById(long rateid);
}