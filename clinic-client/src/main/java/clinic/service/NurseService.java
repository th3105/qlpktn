package clinic.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import clinic.business.Doctor;
import clinic.business.Nurse;

@Service
public class NurseService {
	@Autowired
	private RestTemplate restTemplate = new RestTemplate();
	
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public List<Nurse> findAll(){
		return (List<Nurse>) Arrays.asList(restTemplate.getForObject("http://localhost:8181/nurse", Nurse[].class));
	}
	
	public void update(Integer id, Nurse nurse) {
	     restTemplate.put("http://localhost:8181/nurse/update/"+id,  nurse);
	}
	
	public void delete(Integer id) {
	    restTemplate.delete("http://localhost:8181/nurse/delete/{id}", id);
	}

	public Nurse create(Nurse nurse) {
	    return restTemplate.postForObject("http://localhost:8181/nurse", nurse, Nurse.class);
	}

	public List<Nurse> findByTen( String ten){
		return (List<Nurse>) Arrays.asList(restTemplate.getForObject("http://localhost:8181/nurse/find?ten="+ten, Nurse[].class));
	}
	
	public Nurse findById( Integer id){
		return restTemplate.getForObject("http://localhost:8181/nurse/find/"+id, Nurse.class);
	}
}
