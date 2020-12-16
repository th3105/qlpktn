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

import com.example.ClinicServer.business.Nurse;
import com.example.ClinicServer.service.NurseService;

@RestController
@CrossOrigin(origins = "")
@RequestMapping(path = "/nurse", produces = "application/json")
public class NurseAPI {
	
	@Autowired
	private NurseService nurseService;
	
	
	@GetMapping
	public List<Nurse> findAll(){
		return nurseService.findAll();
	}
	
	@GetMapping(value = "/find/{id}")
	public Nurse findNurseById(@PathVariable("id") Integer id) {
		Optional<Nurse> optNurse = nurseService.findById(id);
		if(optNurse.isPresent()) {
			return optNurse.get();
		}
		return null;
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Nurse addNurse(@RequestBody Nurse nurse) {
		return nurseService.save(nurse);
	}
	
	@PutMapping(value = "/update/{id}")
	public Nurse updateNurse(@RequestBody Nurse nurse, @PathVariable Integer id) {
		nurse.setId(id);
		Optional<Nurse> optNurse = nurseService.findById(id);
		return nurseService.save(nurse);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void deleteNurse(@PathVariable("id") Integer id) {
		try {
			nurseService.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
		}
	}
	
	@GetMapping(value = "/find")
	public List<Nurse> findNurseByName(@RequestParam(defaultValue = "") String ten){
		List<Nurse> list = nurseService.findByTenLike(ten);
		return list;
	}
}
