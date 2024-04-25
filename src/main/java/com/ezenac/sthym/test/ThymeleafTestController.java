package com.ezenac.sthym.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/th")
public class ThymeleafTestController 
{
	 
	
   @GetMapping("")
   @ResponseBody
   public String index()
   {
      return "Thymeleaf Test Controller";
   }
   
   @GetMapping("/test")
   public String test(Model model)
   {
	  
      model.addAttribute("data", "Hello World");
      List<String> slist = new ArrayList<>();
      slist.add("smith");
      slist.add("james");
      slist.add("jieun");
      model.addAttribute("list",slist);
      
      List<Emp> elist=getList();

      model.addAttribute("emps",elist);
      return "thymeleaf/test";
   }
   @GetMapping("detail")
   public String detail(@RequestParam("empno") int empno,Model m)
   {
	  
	  List<Emp> elist=getList();
	  Emp e = new Emp(empno);
	  if(elist.contains(e)) {
		  Emp emp=elist.get(elist.indexOf(e));
		  m.addAttribute("e",emp);
	  }
	 System.out.println("여기까지");
	  
      return "thymeleaf/detail";
   }
   
   public List<Emp> getList(){
	   List<Emp> elist = new ArrayList<>();
	      elist.add(new Emp(11,"smith",new Date()));
	      elist.add(new Emp(12,"james",new Date()));
	      elist.add(new Emp(13,"jieun",new Date()));
	   return elist;
   }
   
}