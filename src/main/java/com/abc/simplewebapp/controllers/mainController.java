package com.abc.simplewebapp.controllers;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mainController {

    @Value("${spring.application.name}")
    String appName;
    
    
	@GetMapping("/")
	public String holeMethod() {
		return "Welcome to my first web application";
	}
	
	@GetMapping("/hello")
	public String greetingMethod() {
		return "Hello, people";
	}
	
	@GetMapping("/getMap")
	public Object mapMethod() {
		Map<Integer, String> myMap = new HashMap<>();
		myMap.put(143, "waleed elba");
		myMap.put(234, "Jim Smith");
		myMap.put(388, "Ryan Dodd");
		
		return myMap;
	}
	
	/*
	 * @GetMapping("/welcome") public Object showWelcomePage() { // returns the JSP
	 * file return new ModelAndView("welcome"); }
	 */
	
	@PostMapping("/formProcessor")
	public Object formMethod(
			@RequestParam("first_name") String firstName,
            @RequestParam("last_name") String lastName,
            @RequestParam("date_graduated") Date dateGraduated,
            @RequestParam("score") Integer score,
            @RequestParam("city") String city,
            @RequestParam("desired_college") Character desiredCollege,
            @RequestParam("comments") String comments
            ) {
		
		String response = "form submitted to app: " + appName + "<br>" +
				"name: " + firstName + " " + lastName + "<br>" +
				"date graduated: " + dateGraduated + "<br>" +
				"score: " + score + "<br>" +
				"city: " + city + "<br>" +
				"desired college: " + desiredCollege + "<br>" +
				"comments: " + comments;
		
		return response;
	}
	
	@PostMapping("/formProcessorRequest")
	public Object formMethod2(HttpServletRequest req) {
		
		Object firstName = req.getParameter("first_name");
		Object lastName = req.getParameter("last_name");
		Object dateGraduated = req.getParameter("date_graduated");
		Object score = req.getParameter("score");
		Object city = req.getParameter("city");
		Object desiredCollege = req.getParameter("desired_college");
		Object comments = req.getParameter("comments");
		
		String response = "form submitted to app: " + appName + " recieving by Model!";
		return response + ", " + firstName;
	}
	
	// go to: C:/Development/Projects/Isolated%20scripts/college_form.html
	@PostMapping("/formProcessorModel")
	public Object formMethod3(@ModelAttribute("regForm") RegisterForm regForm) {
		
		String response = "form submitted to app: " + appName + " recieving by Model!";
		return response + ", " + regForm.getFirstName();
	}
	
	/* RESTful, REST API:
	 * go to Postman, choose "Post" operation, 
	 * and use: http://localhost:8186/formProcessorAPI
	 * and put this in body > json:
	{
	    "firstName": "Michael",
	    "lastName": "Gordon",
	    "dateGraduated": "2022-10-23",
	    "score": 4,
	    "city": "Chicago",
	    "desiredCollege": "c",
	    "comments": "some comments go here"
	}
	*/
	@PostMapping("/formProcessorAPI")
	public ResponseEntity<RegisterForm> formPostAPI(@RequestBody RegisterForm regForm) {
		regForm.setLastName(regForm.getLastName() + " XVI");
		return new ResponseEntity<RegisterForm>(regForm, HttpStatus.ACCEPTED);
	}

}
