package com.example.ClinicServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ClinicServer.business.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{
	Patient findOneById(Integer id);
	List<Patient> findByTenLike(String ten);
}
//