package com.medical.backend.repositories;

import com.medical.backend.entities.Patology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatologyRepository extends JpaRepository<Patology,Long> {
}
