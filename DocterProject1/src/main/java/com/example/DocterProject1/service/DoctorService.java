package com.example.DocterProject1.service;

import com.example.DocterProject1.dao.DoctorRepository;
import com.example.DocterProject1.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;
    public Doctor savedoctor(Doctor doctor) {
      return   doctorRepository.save(doctor);

    }



    public Doctor findbydoctorId(String doctorId) {

            return doctorRepository.findById(Integer.valueOf(doctorId)).get();

    }
}
