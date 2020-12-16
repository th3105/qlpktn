package clinic.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import clinic.business.Patient;
import clinic.business.Patient;
import clinic.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/add")
	public String add(ModelMap model) {
		model.addAttribute("patient",new Patient());
		return "patient/addOrEdit";
	}
	
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, Patient patient) {
		patientService.create(patient);
		model.addAttribute(patient);
		return "patient/addOrEdit";
	}
	
	
	@GetMapping("/edit/{id}")
	public String editpatient(@PathVariable("id") int id, Model model) {
		Patient patient= patientService.findById(id);
		model.addAttribute("patient", patient);
		return "patient/editpatient";
	}
	@PostMapping("/edit/{id}")
	public String update(@PathVariable(name="id") Integer id , @RequestParam("ten") String ten,
		@RequestParam("cmt") String cmt,@RequestParam("ngaysinh") String ngaysinh,
		@RequestParam("diachi") String diachi, @RequestParam("thamnien") String thamnien ,
		@RequestParam("trinhdo") String trinhdo,@RequestParam("sdt") String sdt) {
		Patient exsPatient= patientService.findById(id);
		exsPatient.setCmt(Integer.parseInt(cmt));
		exsPatient.setTen(ten);
		exsPatient.setNgaysinh(ngaysinh);
		exsPatient.setDiachi(diachi);
		exsPatient.setSdt(sdt);	
		patientService.update(id, exsPatient);

		return "redirect:/patient/list";
	}
	@RequestMapping("/list")
	public String list(ModelMap model) {
		List<Patient> list = (List<Patient>) patientService.findAll();
		model.addAttribute("patients",list);
		return "patient/list";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(ModelMap model,@PathVariable(name="id") Integer id) {
		patientService.delete(id);
		return "redirect:/patient/list";
	}
	
	@RequestMapping("/find")
	public String findByTen(ModelMap model,@RequestParam(defaultValue = "")  String ten ) {
		
		List<Patient> list = patientService.findByTen(ten); 
		System.out.println("----->" +list);
		model.addAttribute("patients", list);
		return "patient/find";
	}
}
