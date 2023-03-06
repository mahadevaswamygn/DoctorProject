package com.example.DocterProject1.dao;

import com.example.DocterProject1.model.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor,Integer> {
}
