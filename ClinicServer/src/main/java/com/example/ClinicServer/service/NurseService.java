package com.example.ClinicServer.service;

import java.util.List;
import java.util.Optional;
import com.example.ClinicServer.business.Nurse;
public interface NurseService {
	void deletaAll();
	
	void deleteAll(List<Nurse> nurses);
	
	void delete(Nurse nurse);
	
	void deleteById(Integer id);
	
	
	boolean existedById(Integer id);
	
	Optional<Nurse> findById(Integer id);
	
	List<Nurse> saveAll(Iterable<Nurse> nurses);
	
	List<Nurse> findAllById(Iterable<Integer> ids);
	
	List<Nurse> findAll();
	
	Nurse save(Nurse nurse);
	
	List<Nurse> findByTenLike(String ten);
}
