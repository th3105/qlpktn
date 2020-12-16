package clinic.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import clinic.business.Doctor;
import clinic.business.Patient;

@Service
public class PatientService {
	@Autowired
	private RestTemplate restTemplate = new RestTemplate();

	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public List<Patient> findAll(){
		return (List<Patient>) Arrays.asList(restTemplate.getForObject("http://localhost:8181/patient", Patient[].class));
	}
	
	public void update(Integer id, Patient patient) {
	     restTemplate.put("http://localhost:8181/patient/update/"+ id,  patient);
	}
	
	public void delete(Integer id) {
	    restTemplate.delete("http://localhost:8181/patient/delete/{id}", id);
	}

	public Patient create(Patient patient) {
	    return restTemplate.postForObject("http://localhost:8181/patient", patient, Patient.class);
	}

	public List<Patient> findByTen( String ten){
		return (List<Patient>) Arrays.asList(restTemplate.getForObject("http://localhost:8181/patient/find?ten="+ten, Patient[].class));
	}
	
	public Patient findById( Integer id){
		return restTemplate.getForObject("http://localhost:8181/patient/find/"+id, Patient.class);
	}
}
