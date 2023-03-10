package com.example.DocterProject1.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "tbl_patient")
public class Patient {
    @Id
    @Column(name = "patient_id")
    private  Integer patientId;
    @Column(name = "patient_name")
    private String patientName;
    @Column(name = "age")
    private Integer age;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "disease_type")
    private String diseaseType;
    @Column(name = "gender")
    private String gender;
    @Column(name = "admit_date")
    private Timestamp admitDate;
    @JoinColumn(name = "doctor_id")
    @ManyToOne
    private Doctor doctorId;

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getDiseaseType() {
        return diseaseType;
    }

    public String getGender() {
        return gender;
    }

    public Doctor getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Doctor doctorId) {
        this.doctorId = doctorId;
    }

    public Timestamp getAdmitDate() {
        return admitDate;
    }

    public void setAdmitDate(Timestamp admitDate) {
        this.admitDate = admitDate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDiseaseType(String diseaseType) {
        this.diseaseType = diseaseType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}
