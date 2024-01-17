package com.project.authenticator.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.authenticator.entities.Users;
import com.project.authenticator.services.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<Users> findAll(){
		return this.userService.findAll();
	}
}
