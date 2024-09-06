package com.phbank.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phbank.dto.DepositDTO;
import com.phbank.model.CustomerModel;
import com.phbank.services.BankServiceImpl;
import com.phbank.services.CustomerDetails;

@Controller
@RequestMapping("/home/services")
public class ServiceController {
	
	private CustomerDetails details;
	private BankServiceImpl services;
	
	public ServiceController(CustomerDetails details, BankServiceImpl services) {
		this.details = details;
		this.services = services;
	}
	
	@GetMapping("/")
	public String serviceMainPage(Model model) {
		model.addAttribute("balance", services.getBalance(details.getAcctNum()));
		model.addAttribute("editInfo", details.getDetails());
		model.addAttribute("deposit", new DepositDTO());
		model.addAttribute("transaction", services.getTransactions(details.getAcctNum()));
		
		return "Services";
	}
	
	@PostMapping("/processAccountInfo")
	public String accountInfoProcessing(@ModelAttribute("editInfo") CustomerModel cust) {
		services.editInfo(details.getAcctNum(), cust.getName(),cust.getAddress(),cust.getContact());
		details.updateName(cust);
		
		return "redirect:/home/services/";
	}
	
	
	

}
