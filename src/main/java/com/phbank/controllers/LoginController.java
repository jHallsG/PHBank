package com.phbank.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phbank.dto.LoginDTO;

import jakarta.validation.Valid;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@GetMapping("/")
	public String login(@ModelAttribute("creds") LoginDTO loginDto) {
		return "Login";
	}
	
	@PostMapping("/processLogin")
	public String loginProcessing(@ModelAttribute("creds") LoginDTO loginDto) {
		
		return "redirect:/home/";
	}

}
