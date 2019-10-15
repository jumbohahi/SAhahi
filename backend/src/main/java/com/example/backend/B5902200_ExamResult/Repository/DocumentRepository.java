package com.example.backend.B5902200_ExamResult.Repository;
import com.example.backend.B5902200_ExamResult.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface DocumentRepository extends JpaRepository<Document, Long> {}    //JPA เป็นตัว map class ให้เป็น Database