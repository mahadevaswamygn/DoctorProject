package com.example.DocterProject1.controller;

import com.example.DocterProject1.dao.DoctorRepository;
import com.example.DocterProject1.model.Doctor;
import com.example.DocterProject1.model.Patient;
import com.example.DocterProject1.service.PatientService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class PatientController {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientService patientService;
    @PostMapping(value = "/patient")
    public String savePatient(@RequestBody String patient)
    {
        JSONObject jsonObject=new JSONObject(patient);
        Patient patient1=setPatient(jsonObject);
        patientService.savePatient(patient1);
        return "saved";
    }
    @GetMapping(value = "/patient")
    public List<Patient> getPatient(@Nullable @RequestParam String doctorId,
                                   @Nullable @RequestParam String patientId)
    {
        return patientService.getPatients(doctorId,patientId);

    }

    private Patient setPatient(JSONObject jsonObject) {
        Patient patient=new Patient();
        patient.setPatientId(jsonObject.getInt("patientId"));
        patient.setPatientName(jsonObject.getString("patientName"));
        patient.setAge(jsonObject.getInt("age"));
        patient.setGender(jsonObject.getString("gender"));
        patient.setDiseaseType(jsonObject.getString("diseaseType"));
        patient.setPhoneNumber(jsonObject.getString("phoneNumber"));
        Timestamp aditime=new Timestamp(System.currentTimeMillis());
        patient.setAdmitDate(aditime);
        String doctorid=jsonObject.getString("doctorId");
        Doctor doctor=doctorRepository.findById(Integer.valueOf(doctorid)).get();
        patient.setDoctorId(doctor);
        return patient;

    }
}
