 package com.emp_management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.emp_management.entity.Employee;
import com.emp_management.service.EmpService;


import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	
	
	@GetMapping("/")
	public String home(HttpSession session, Model model) {
	    String msg = (String) session.getAttribute("msg");
	    if (msg != null) {
	        model.addAttribute("msg", msg);
	        session.removeAttribute("msg");
	    }
	    System.out.println("Home page accessed, msg: " + msg);
	    
	    List<Employee> emp = service.getAllEmp();
	    model.addAttribute("emp",emp);
	    return "index";
	}
	
	
	
	
	@GetMapping("/addEmp")
	public String addEmp() {
		return "addEmp";
	}
	
	
	
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e, HttpSession session) {
		
		System.out.println(e);
		service.addEmp(e);
		
		session.setAttribute("msg", "Employee added successfully..");
		
		return "redirect:/";
	}
	

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
	    Optional<Employee> optionalEmployee = service.getEmpById(id);
	    
	    if (optionalEmployee.isPresent()) {
	        model.addAttribute("emp", optionalEmployee.get());
	    } else {
	        // Handle the case where the employee is not found
	        return "redirect:/not-found"; // Adjust this as needed
	    }
	    
	    return "edit";
	}


	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e, HttpSession session) {
		service.addEmp(e);
		session.setAttribute("msg", "Employee Updated Successfully...");
		return "redirect:/";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id, HttpSession session) {
		service.deleteEmp(id);
		session.setAttribute("msg", "Employee Deleted Successfully...");
		return "redirect:/";
	}

}
