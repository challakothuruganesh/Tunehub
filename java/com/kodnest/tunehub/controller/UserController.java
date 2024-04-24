package com.kodnest.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.tunehub.serviceimpl.UserServiceImpl;
import com.kodnest.tunehub.entity.User;

@Controller
public class UserController {

	@Autowired
	UserServiceImpl userService;

	@PostMapping("/register") 
	public String addUser(@ModelAttribute User user) {

		//to check a user with a a mail is present or not
		boolean userExists = userService.emailExists(user);

		if(userExists==false) {
			userService.saveUser(user);		
			System.out.println("User added successfully");
		}
		else {
			System.out.println("Duplicate user");
		}

		return "login";

	}

	@PostMapping("/validate") 
	public String validate(@RequestParam("email") String email, 
			@RequestParam("password") String password) {

		if(userService.validUser(email, password)==true) {

			String role = userService.getRole(email);

			if(role.equals("admin")) {
				return"adminhome";
			}else{
				return "cutomerhome";
			}

		}
		else {
			return "login";
		}

	}
}