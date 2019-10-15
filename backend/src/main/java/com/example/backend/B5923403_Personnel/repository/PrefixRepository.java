package com.example.backend.B5923403_Personnel.repository;

import com.example.backend.B5923403_Personnel.entity.Prefix;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrefixRepository extends JpaRepository<Prefix , Long> {
    Prefix findById(long prefixId);
}
