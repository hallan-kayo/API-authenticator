package com.project.authenticator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.authenticator.entities.Users;
import com.project.authenticator.entities.dto.AuthenticationDTO;
import com.project.authenticator.entities.dto.LoginResponseDTO;
import com.project.authenticator.entities.dto.RegisterDTO;
import com.project.authenticator.repositories.UserRepository;
import com.project.authenticator.security.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticatorController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenService tokenService;
	
	@PostMapping("login")
	public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		
		var token = tokenService.generationToken((Users)auth.getPrincipal());
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
	
	@PostMapping("register")
	public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
		if(this.userRepository.findByLogin(data.login()) !=null ) 
			return ResponseEntity.badRequest().build();
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
		Users newUser = new Users(data.login(), encryptedPassword, data.role());
		
		this.userRepository.save(newUser);
		return ResponseEntity.ok().build();
	}
}
