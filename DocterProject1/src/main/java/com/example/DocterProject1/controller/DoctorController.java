package com.example.DocterProject1.controller;

import com.example.DocterProject1.model.Doctor;
import com.example.DocterProject1.service.DoctorService;

import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @PostMapping(value = "/doctor")
    public Doctor savedoctor(@RequestBody Doctor doctor)
    {

        return doctorService.savedoctor(doctor);
    }


    @GetMapping(value = "/doctor")
    public Doctor findByDoctorId(@Nullable @RequestParam String doctorId)
    {
        return doctorService.findbydoctorId(doctorId);
    }

}
