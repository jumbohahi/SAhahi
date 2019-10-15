package com.example.backend.B5923403_Personnel.repository;

import com.example.backend.B5923403_Personnel.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PositionRepository extends JpaRepository<Position, Long> {
    Position findById(long positionId);
}
