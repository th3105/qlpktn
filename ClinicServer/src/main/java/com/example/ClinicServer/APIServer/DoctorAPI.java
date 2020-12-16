package com.example.ClinicServer.APIServer;

import java.util.List;
import java.util.Optional;

import javax.print.Doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ClinicServer.business.Doctor;
import com.example.ClinicServer.service.DoctorService;

@RestController
@CrossOrigin(origins = "")
@RequestMapping(path = "/doctor", produces = "application/json")
public class DoctorAPI {
	
	@Autowired
	private DoctorService doctorService;
	
	
	@GetMapping
	public List<Doctor> findAll(){
		return doctorService.findAll();
	}
	
	@GetMapping(value = "/find/{id}")
	public Doctor findDoctorById(@PathVariable("id") Integer id) {
		Optional<Doctor> optDoctor = doctorService.findById(id);
		if(optDoctor.isPresent()) {
			return optDoctor.get();
		}
		return null;
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return doctorService.save(doctor);
	}
	
	@PutMapping(value = "/update/{id}")
	public Doctor updateDoctor(@RequestBody Doctor doctor, @PathVariable Integer id) {
		doctor.setId(id);
		Optional<Doctor> optDoctor = doctorService.findById(id);
		return doctorService.save(doctor);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void deleteDoctor(@PathVariable("id") Integer id) {
		try {
			doctorService.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
		}
	}
	
	@GetMapping(value = "/find")
	public List<Doctor> findDoctorByName(@RequestParam(defaultValue = "") String ten){
		List<Doctor> list = doctorService.findByTenLike(ten);
		return list;
	}
}
