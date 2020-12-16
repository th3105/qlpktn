package com.example.ClinicServer.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import com.example.ClinicServer.business.Doctor;
public interface DoctorService {
	void deletaAll();
	
	void deleteAll(List<Doctor> doctors);
	
	void delete(Doctor doctor);
	
	void deleteById(Integer id);
	
	
	boolean existedById(Integer id);
	
	Optional<Doctor> findById(Integer id);
	
	List<Doctor> saveAll(Iterable<Doctor> doctors);
	
	List<Doctor> findAllById(Iterable<Integer> ids);
	
	List<Doctor> findAll();
	
	Doctor save(Doctor doctor);
	
	List<Doctor> findByTenLike(String ten);
}
