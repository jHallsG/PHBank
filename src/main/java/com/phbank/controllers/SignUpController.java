package com.phbank.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phbank.dto.SignUpDTO;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/signup")
public class SignUpController {
	
	@GetMapping("/")
	public String signup(@ModelAttribute("s_creds") SignUpDTO signUpDTO) {
		return "SignUp";
	}
	
	@PostMapping("/processSignUp")
	public String loginProcessing(@Valid @ModelAttribute("s_creds") SignUpDTO signUpDTO, BindingResult res) {
		if(res.hasErrors()) {
			List<ObjectError> listOfErrors = res.getAllErrors();
			
			for(ObjectError err : listOfErrors) {
				System.out.println(err);
			}
			
			return "SignUp";
		}
		
		return "redirect:/login/";
	}

}
