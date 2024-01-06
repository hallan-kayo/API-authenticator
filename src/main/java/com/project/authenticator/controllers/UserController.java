package com.project.authenticator.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.authenticator.entities.Users;
import com.project.authenticator.services.UserService;

@RestController
@RequestMapping(value = "users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<Users> findAll(){
		return this.userService.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Users> save(@RequestBody Users user){
		user = userService.save(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);
	}
}
