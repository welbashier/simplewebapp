package com.abc.simplewebapp.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class mainControllerTest {


	@Autowired
	private TestRestTemplate template;

    @Test
    public void getHello() throws Exception {
    	// spring boot returns ResponseEntity
        ResponseEntity<String> response = template.getForEntity("/", String.class);
        
        assertTrue(response.getBody().contains("Welcome"));
    }
    
    @Test
    public void givenTwoJsonFormats_whenDeserialized_thenObjectsCreated() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        RegisterForm registerForm = mapper.readValue("{\r\n" + 
        		"    \"first_name\": \"waleed\",\r\n" + 
        		"    \"last_name\": \"elbashier\",\r\n" + 
        		"}", RegisterForm.class);

        assertEquals("waleed", registerForm.getFirstName());

        registerForm = mapper.readValue("{\r\n" + 
        		"    \"fname\": \"waleed\",\r\n" + 
        		"    \"last_name\": \"elbashier\",\r\n" + 
        		"}", RegisterForm.class);

        assertEquals("waleed", registerForm.getFirstName());
    }
}
