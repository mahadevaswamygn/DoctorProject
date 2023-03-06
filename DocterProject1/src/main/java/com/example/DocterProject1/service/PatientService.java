package com.example.DocterProject1.service;

import com.example.DocterProject1.dao.PatientRepository;
import com.example.DocterProject1.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    public void savePatient(Patient patient)
    {
        patientRepository.save(patient);
    }

    public List<Patient> getPatients(String doctorId, String patientId) {
        List<Patient> pList = new ArrayList<>();
        List<Patient> onlyPatients = new ArrayList<>();
        if(doctorId != null)
        {
            pList=patientRepository.findAll();
            for (Patient patient :pList)
            {
                if(patient.getDoctorId().getDoctorId() == (Integer.valueOf(doctorId)))
                {
                    onlyPatients.add(patient);
                }

            }
        }
        else if(patientId != null)
        {
            List<Integer> ids = new ArrayList<>();
            ids.add(Integer.parseInt(patientId));
            pList=patientRepository.findAllById(ids);
            return pList;
        }
        else if(doctorId==null && patientId == null)
        {
            pList=patientRepository.findAll();
            return pList;
        }
        return pList;
    }
}
