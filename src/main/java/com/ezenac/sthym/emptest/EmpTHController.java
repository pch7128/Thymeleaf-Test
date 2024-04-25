package com.ezenac.sthym.emptest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/thcrud")
public class EmpTHController {
	
	@Autowired
	private EmpSvc svc;

	
	@GetMapping("/emp/input")
	public String addForm() {
		return "thymeleaf/emp/empAddForm";
	}
	
	@PostMapping("/emp/input")
	@ResponseBody
	public Map<String,Object> added(EmpVO e){
		
		System.out.println(e.getEmpno());
		boolean added=svc.addEmp(e);
		Map<String,Object> map = new HashMap<>();
		map.put("added", added);
		map.put("empno",e.getEmpno());
		return map;
	}
	
	@GetMapping("/emp/detail")
	public String empDetail(@RequestParam("empno") int empno, Model m) {
		
		EmpVO e=svc.getEmp(empno);
		m.addAttribute("e", e);
		return "thymeleaf/emp/empDetail";
	}
	
	@GetMapping("/emp/list")
	public String empList(Model m) {
		
		List<EmpVO> elist=svc.getList();
		m.addAttribute("elist", elist);
		return "thymeleaf/emp/empList";
	}

	
	@PostMapping("/emp/delete")
	@ResponseBody
	public Map<String,Boolean> empDelete(@RequestParam("empno") int empno){
		
		boolean deleted=svc.deleteEmp(empno);
		Map<String,Boolean> map = new HashMap<>();
		map.put("deleted", deleted);
		
		return map;
	}
	
	@GetMapping("/emp/update")
	public String empEditForm(@RequestParam("empno") int empno,Model m) {
		
		EmpVO e=svc.getEmp(empno);
		m.addAttribute("e", e);
		return "thymeleaf/emp/empEdit";
	}
	
	@PostMapping("/emp/update")
	@ResponseBody
	public Map<String,Object> empEdit(EmpVO e){
		
		boolean edit=svc.editEmp(e);
		Map<String,Object> map = new HashMap<>();
		map.put("empno", e.getEmpno());
		map.put("edit", edit);
		return map;
	}
}
