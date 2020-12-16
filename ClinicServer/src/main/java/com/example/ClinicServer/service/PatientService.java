package com.example.ClinicServer.service;

import java.util.List;
import java.util.Optional;

import com.example.ClinicServer.business.Patient;
public interface PatientService {
	void deletaAll();
	
	void deleteAll(List<Patient> patients);
	
	void delete(Patient patient);
	
	void deleteById(Integer id);
	
	
	boolean existedById(Integer id);
	
	Optional<Patient> findById(Integer id);
	
	List<Patient> saveAll(Iterable<Patient> patients);
	
	List<Patient> findAllById(Iterable<Integer> ids);
	
	List<Patient> findAll();
	
	Patient save(Patient patient);
	
	List<Patient> findByTenLike(String ten);
}
