package com.greatlearning.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.customer.entity.Customer;
import com.greatlearning.customer.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String listForms(Model theModel) {
		List<Customer> theCustomers=customerService.findAll();
		
		//connecting  the model to the view
		theModel.addAttribute("Customers", theCustomers);
		
		return "list-customers";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		//adding a new customer object to bind to the form data
		Customer customer=new Customer();
		
		theModel.addAttribute("customer", customer);
		
		return "Customer-form";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForDelete(@RequestParam("customerId") int theId,Model theModel) {
		//getting the customer first whose records has to be updated
		Customer customer=customerService.findById(theId);
		
		// set Customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", customer);
		
		return "Customer-form";
	}
	
	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id,@RequestParam("fName") String fName,
			@RequestParam("lName") String lName,@RequestParam("email") String email) {
		
		System.out.println(id);
		Customer customer=null;
		if(id!=0) {			
			//finding the customer by Id first in case of an update
			customer=customerService.findById(id);
			customer.setfName(fName);
			customer.setlName(lName);
			customer.setEmail(email);
		}else {
			//creating a new object in case for a new record
			customer=new Customer(fName, lName, email);
		}
	    
		//save the customer
		customerService.addOrUpdate(customer);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/customer/list";		
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("customerId") int customerId) {
		//delete the customer
		customerService.deleteById(customerId);
		
		//return to Customers page
		return "redirect:/customer/list";
	}
	
	

}
