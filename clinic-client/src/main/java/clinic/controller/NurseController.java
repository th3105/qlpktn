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

import clinic.business.Nurse;
import clinic.business.Nurse;
import clinic.business.Nurse;
import clinic.service.NurseService;

@Controller
@RequestMapping("/nurse")
public class NurseController {
	
	@Autowired
	private NurseService nurseService;
	
	@GetMapping("/add")
	public String add(ModelMap model) {
		model.addAttribute("nurse",new Nurse());
		return "nurse/addOrEdit";
	}
	
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, Nurse nurse) {
		nurseService.create(nurse);
		model.addAttribute(nurse);
		return "nurse/addOrEdit";
	}
	
	
	@GetMapping("/edit/{id}")
	public String editnurse(@PathVariable("id") int id, Model model) {
		Nurse nurse= nurseService.findById(id);
		model.addAttribute("nurse", nurse);
		return "nurse/editnurse";
	}
	@PostMapping("/edit/{id}")
	public String update(@PathVariable(name="id") Integer id , @RequestParam("ten") String ten,
		@RequestParam("cmt") String cmt,@RequestParam("ngaysinh") String ngaysinh,
		@RequestParam("diachi") String diachi, @RequestParam("thamnien") String thamnien ,
		@RequestParam("trinhdo") String trinhdo,@RequestParam("sdt") String sdt) {
		Nurse exsNurse= nurseService.findById(id);
		
		exsNurse.setCmt(Integer.parseInt(cmt));
		exsNurse.setTen(ten);
		exsNurse.setNgaysinh(ngaysinh);
		exsNurse.setDiachi(diachi);
		//exsNurse.setBacnghe(bacnghe);
		exsNurse.setThamnien(thamnien);
		exsNurse.setTrinhdo(trinhdo);
		exsNurse.setSdt(sdt);	
		nurseService.update(id, exsNurse);

		return "redirect:/nurse/list";
	}
	@RequestMapping("/list")
	public String list(ModelMap model) {
		List<Nurse> list = (List<Nurse>) nurseService.findAll();
		model.addAttribute("nurses",list);
		return "nurse/list";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(ModelMap model,@PathVariable(name="id") Integer id) {
		nurseService.delete(id);
		return "redirect: /nurse/list";
	}
	
	@RequestMapping("/find")
	public String findByTen(ModelMap model,@RequestParam(defaultValue = "")  String ten ) {
		
		List<Nurse> list = nurseService.findByTen(ten); 
		System.out.println("----->" +list);
		model.addAttribute("nurses", list);
		return "nurse/find";
	}
}
