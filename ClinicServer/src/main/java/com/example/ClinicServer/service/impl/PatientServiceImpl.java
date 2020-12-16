package com.example.ClinicServer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.example.ClinicServer.business.Patient;
import com.example.ClinicServer.repository.PatientRepository;
import com.example.ClinicServer.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientRepository patientRepo;

	@Override
	public void deletaAll() {
		// TODO Auto-generated method stub
		patientRepo.deleteAll();
	}

	@Override
	public void deleteAll(List<Patient> patients) {
		// TODO Auto-generated method stub
		patientRepo.deleteAll(patients);
	}

	@Override
	public void delete(Patient patient) {
		// TODO Auto-generated method stub
		patientRepo.delete(patient);
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		patientRepo.deleteById(id);
	}

	@Override
	public boolean existedById(Integer id) {
		// TODO Auto-generated method stub
		return patientRepo.existsById(id);
	}

	@Override
	public Optional<Patient> findById(Integer id) {
		// TODO Auto-generated method stub
		return patientRepo.findById(id);
	}

	@Override
	public List<Patient> saveAll(Iterable<Patient> patients) {
		// TODO Auto-generated method stub
		return patientRepo.saveAll(patients);
	}

	@Override
	public List<Patient> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return patientRepo.findAllById(ids);
	}

	@Override
	public List<Patient> findAll() {
		// TODO Auto-generated method stub
		return patientRepo.findAll();
	}

	@Override
	public Patient save(Patient patient) {
		// TODO Auto-generated method stub
		return patientRepo.save(patient);
	}

	@Override
	public List<Patient> findByTenLike(String ten) {
		// TODO Auto-generated method stub
		return patientRepo.findByTenLike("%" + ten + "%");
	}

}
