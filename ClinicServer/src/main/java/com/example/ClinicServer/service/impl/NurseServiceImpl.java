package com.example.ClinicServer.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.ClinicServer.business.Nurse;
import com.example.ClinicServer.repository.NurseRepository;
import com.example.ClinicServer.service.NurseService;

@Service
public class NurseServiceImpl implements NurseService {
	
	@Autowired
	private NurseRepository nurseRepo;
	
	
	@Override
	public void deletaAll() {
		// TODO Auto-generated method stub
		nurseRepo.deleteAll();
	}

	@Override
	public void deleteAll(List<Nurse> nurses) {
		// TODO Auto-generated method stub
		nurseRepo.deleteAll(nurses);
		
	}

	@Override
	public void delete(Nurse nurse) {
		// TODO Auto-generated method stub
		nurseRepo.delete(nurse);
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		nurseRepo.deleteById(id);
	}

	@Override
	public boolean existedById(Integer id) {
		// TODO Auto-generated method stub
		return nurseRepo.existsById(id);
	}

	@Override
	public Optional<Nurse> findById(Integer id) {
		// TODO Auto-generated method stub
		return nurseRepo.findById(id);
	}

	@Override
	public List<Nurse> saveAll(Iterable<Nurse> nurses) {
		// TODO Auto-generated method stub
		return (List<Nurse>) nurseRepo.saveAll(nurses);
	}

	@Override
	public List<Nurse> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return nurseRepo.findAllById(ids);
	}

	@Override
	public List<Nurse> findAll() {
		// TODO Auto-generated method stub
		return nurseRepo.findAll();
	}

	@Override
	public List<Nurse> findByTenLike(String ten) {
		// TODO Auto-generated method stub
		return nurseRepo.findByTenLike("%" + ten + "%");
	}

	@Override
	public Nurse save(Nurse doctor) {
		// TODO Auto-generated method stub
		return nurseRepo.save(doctor);
	}
}
