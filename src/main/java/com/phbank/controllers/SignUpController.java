package com.phbank.controllers;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.phbank.dto.SignUpDTO;
import com.phbank.services.RegistrationImpl;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/signup")
public class SignUpController {
	
	private final RegistrationImpl registrationImpl;
	
	public SignUpController(RegistrationImpl registrationImpl) {
		this.registrationImpl = registrationImpl;
	}
	
	@GetMapping("/")
	public String signup(@ModelAttribute("s_creds") SignUpDTO signUpDTO) {
		return "SignUp";
	}
	
	@PostMapping("/processSignUp")
	public String loginProcessing(@Valid @ModelAttribute("s_creds") SignUpDTO signUpDTO, BindingResult res, RedirectAttributes redirect) {
		
		try {
			
			if(res.hasErrors()) {
				List<ObjectError> listOfErrors = res.getAllErrors();
				
				for(ObjectError err : listOfErrors) {
					System.out.println(err);
				}
				
				return "SignUp";
			}
			
			registrationImpl.registerUser(signUpDTO.getAcctNum(), signUpDTO.getPassword());
			
		} catch (DataIntegrityViolationException e) {
			res.rejectValue("acctNum", "Error.duplicate.account", e.getMessage());
			return "SignUp";
		} 
		
		redirect.addFlashAttribute("registrationMessage", "Registration Successful!");
		return "redirect:/login/";
	}
}
