package com.phbank.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phbank.dto.LoginDTO;

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
