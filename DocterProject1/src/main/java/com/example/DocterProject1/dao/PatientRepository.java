package com.example.DocterProject1.dao;

import com.example.DocterProject1.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
