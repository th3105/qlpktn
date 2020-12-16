package com.example.ClinicServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ClinicServer.business.Nurse;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, Integer> {
	Nurse findOneById(Integer id);
	List<Nurse> findByTenLike(String ten);
}
