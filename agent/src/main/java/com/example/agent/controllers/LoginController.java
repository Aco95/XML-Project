package com.example.agent.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.agent.entities.UserCredential;
import com.example.agent.services.IUserCredentialService;
import com.example.agent.entities.CurrentUser;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class LoginController {

	@Autowired
	private IUserCredentialService userCredentialService;
	
	  @RequestMapping(
	    		value = "/angularUser",
				method = RequestMethod.GET,
				produces = MediaType.APPLICATION_JSON_VALUE)
	    public UserCredential getUserPageAngular(@ModelAttribute("currentUser") CurrentUser currentUser) {
	    	System.out.println("treba da vrati:" +currentUser);
	        return currentUser.getUser();
	    }
	  
	  @RequestMapping(
	    		value = "/checkEmail/{email}",
				method = RequestMethod.GET,
				produces = MediaType.APPLICATION_JSON_VALUE)
	    public Boolean getUserCredential(@PathVariable("email") String email) {
	        
		  return userCredentialService.checkEmail(email);
	    }
}
