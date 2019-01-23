package com.javainuse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javainuse.model.Employee;
import com.javainuse.service.EmployeeService;


@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}

	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addEmployee", "emp", new Employee());
	}

	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("emp") Employee emp) {
		
		employeeService.insertEmployee(emp);
		List<Employee> list = employeeService.getAllEmployees();
		ModelAndView model = new ModelAndView("viewemp");
		model.addObject("list", list);
		return model;
	}
     
	@RequestMapping("/viewemp")
	public ModelAndView getEmployees() {
		List<Employee>list = employeeService.getAllEmployees();
		ModelAndView model = new ModelAndView("viewemp");
		model.addObject("list", list);
		return model;
	}
	
	 /* It displays object data into form for the given id.  
     * The @PathVariable puts URL data into variable.*/  
    @RequestMapping(value="/editemp/{id}")  
    public ModelAndView edit(@PathVariable String id, Model m){  
        Employee emp=employeeService.getEmployeeById(id); 
        ModelAndView model = new ModelAndView("empeditform");
		model.addObject("emp", emp);
		return model;
       
     }  
    
    /* It deletes record for the given id in URL and redirects to /viewemp */  
    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable String id){  
    	Employee emp=employeeService.getEmployeeById(id); 
     employeeService.delete(emp);  
        return "redirect:/viewemp";  
    }   
    
    /* It updates model object. */  
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("emp") Employee emp){  
        employeeService.update(emp);  
        return "redirect:/viewemp";  
    }  

	

}
