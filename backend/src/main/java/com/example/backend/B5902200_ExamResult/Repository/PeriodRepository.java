package com.example.backend.B5902200_ExamResult.Repository;
import com.example.backend.B5902200_ExamResult.Entity.Period;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface PeriodRepository extends JpaRepository<Period, Long> {
	Period findById(long id);
}