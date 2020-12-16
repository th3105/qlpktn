package clinic.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import clinic.business.Doctor;
import clinic.service.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping("/add")
	public String add(ModelMap model) {
		model.addAttribute("doctor",new Doctor());
		return "doctor/addOrEdit";
	}
	
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, Doctor doctor) {
		doctorService.create(doctor);
		model.addAttribute(doctor);
		return "doctor/addOrEdit";
	}
	
	
	/* Chua lam duoc //day la ben client nhecai nay la api a ?
	 * 
	 * */
	@GetMapping("/edit/{id}")
	public String editdoctor(@PathVariable("id") int id, Model model) {
		Doctor doctor= doctorService.findById(id);
		model.addAttribute("doctor", doctor);
		return "doctor/editdoctor";
	}
	
	@PostMapping("/edit/{id}")
	public String update(@PathVariable(name="id") Integer id , @RequestParam("ten") String ten,
		@RequestParam("cmt") String cmt,@RequestParam("ngaysinh") String ngaysinh,
		@RequestParam("diachi") String diachi,
		@RequestParam("bacnghe") String bacnghe ,@RequestParam("thamnien") String thamnien ,
		@RequestParam("trinhdo") String trinhdo,@RequestParam("chuyenmon") String chuyenMon) {
		Doctor exsDoctor= doctorService.findById(id);
		
		exsDoctor.setCmt(Integer.parseInt(cmt));
		exsDoctor.setTen(ten);
		exsDoctor.setNgaysinh(ngaysinh);
		exsDoctor.setDiachi(diachi);
		exsDoctor.setBacnghe(bacnghe);
		exsDoctor.setThamnien(thamnien);
		exsDoctor.setTrinhdo(trinhdo);
		exsDoctor.setChuyenmon(chuyenMon);
		
		doctorService.update(id, exsDoctor);

		return "redirect:/doctor/list";
	}
	
	@RequestMapping("/list")
	public String list(ModelMap model) {
		List<Doctor> list = (List<Doctor>) doctorService.findAll();
		model.addAttribute("doctors",list);
		return "doctor/list";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(ModelMap model,@PathVariable(name="id") Integer id) {
		doctorService.delete(id);
		return "doctor/list";
	}
	
	@RequestMapping("/find")
	public String findByTen(ModelMap model,@RequestParam(defaultValue = "")  String ten ) {
		
		List<Doctor> list = doctorService.findByTen(ten); 
		System.out.println("----->" +list);
		model.addAttribute("doctors", list);
		return "doctor/find";
	}
}
