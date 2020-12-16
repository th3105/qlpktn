package com.example.ClinicServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.ClinicServer.business.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	Doctor findOneById(Integer id);
	List<Doctor> findByTenLike(String ten);
}
