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

import com.example.ClinicServer.business.Patient;
import com.example.ClinicServer.service.PatientService;

@RestController
@CrossOrigin(origins = "")
@RequestMapping(path = "/patient", produces = "application/json")
public class PatientAPI {
	
	@Autowired
	private PatientService patientService;
	
	
	@GetMapping
	public List<Patient> findAll(){
		return patientService.findAll();
	}
	
	@GetMapping(value = "/find/{id}")
	public Patient findPatientById(@PathVariable("id") Integer id) {
		Optional<Patient> optPatient = patientService.findById(id);
		if(optPatient.isPresent()) {
			return optPatient.get();
		}
		return null;
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Patient addPatient(@RequestBody Patient patient) {
		return patientService.save(patient);
	}
	
	@PutMapping(value = "/update/{id}")
	public Patient updatePatient(@RequestBody Patient patient, @PathVariable Integer id) {
		patient.setId(id);
		Optional<Patient> optPatient = patientService.findById(id);
		return patientService.save(patient);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void deletePatient(@PathVariable("id") Integer id) {
		try {
			patientService.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
		}
	}
	
	@GetMapping(value = "/find")
	public List<Patient> findPatientByName(@RequestParam(defaultValue = "") String ten){
		List<Patient> list = patientService.findByTenLike(ten);
		return list;
	}
}
