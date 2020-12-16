package com.example.ClinicServer.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.ClinicServer.business.Doctor;
import com.example.ClinicServer.repository.DoctorRepository;
import com.example.ClinicServer.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepo;
	
	
	@Override
	public void deletaAll() {
		// TODO Auto-generated method stub
		doctorRepo.deleteAll();
	}

	@Override
	public void deleteAll(List<Doctor> doctors) {
		// TODO Auto-generated method stub
		doctorRepo.deleteAll(doctors);
		
	}

	@Override
	public void delete(Doctor doctor) {
		// TODO Auto-generated method stub
		doctorRepo.delete(doctor);
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		doctorRepo.deleteById(id);
	}

	@Override
	public boolean existedById(Integer id) {
		// TODO Auto-generated method stub
		return doctorRepo.existsById(id);
	}

	@Override
	public Optional<Doctor> findById(Integer id) {
		// TODO Auto-generated method stub
		return doctorRepo.findById(id);
	}

	@Override
	public List<Doctor> saveAll(Iterable<Doctor> doctors) {
		// TODO Auto-generated method stub
		return (List<Doctor>) doctorRepo.saveAll(doctors);
	}

	@Override
	public List<Doctor> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return doctorRepo.findAllById(ids);
	}

	@Override
	public List<Doctor> findAll() {
		// TODO Auto-generated method stub
		return doctorRepo.findAll();
	}

	@Override
	public List<Doctor> findByTenLike(String ten) {
		// TODO Auto-generated method stub
		return doctorRepo.findByTenLike("%" + ten + "%");
	}

	@Override
	public Doctor save(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorRepo.save(doctor);
	}
}
