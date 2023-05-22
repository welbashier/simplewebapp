package com.abc.simplewebapp.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class templatesController {

    @Value("${spring.application.name}")
    String appName;
    
	
	@GetMapping("/hx")
	public String showHomeHTMLPage() {
        return "home";
	}
}
