package com.phbank.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HeaderFooterController {
	
	@GetMapping("/header")
    public String getHeader() {
		
        return "Header";
    }

    @GetMapping("/footer")
    public String getFooter() {
        return "Footer";
    }

}
