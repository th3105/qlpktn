package clinic.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import clinic.business.Doctor;

@Service
public class DoctorService {
	@Autowired
	private RestTemplate restTemplate = new RestTemplate();
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public List<Doctor> findAll(){
		return (List<Doctor>) Arrays.asList(restTemplate.getForObject("http://localhost:8181/doctor", Doctor[].class));
	}
	
	public void update(Integer id, Doctor  doctor) {
	     restTemplate.put("http://localhost:8181/doctor/update/"+id,  doctor);
	}
	
	public void delete(Integer id) {
	    restTemplate.delete("http://localhost:8181/doctor/delete/"+id);
	}

	public Doctor create(Doctor doctor) {
	    return restTemplate.postForObject("http://localhost:8181/doctor", doctor, Doctor.class);
	}

	public List<Doctor> findByTen( String ten){
		return (List<Doctor>) Arrays.asList(restTemplate.getForObject("http://localhost:8181/doctor/find?ten="+ten, Doctor[].class));
	}
	
	public Doctor findById( Integer id){
		return restTemplate.getForObject("http://localhost:8181/doctor/find/"+id, Doctor.class);
	}
	
}
