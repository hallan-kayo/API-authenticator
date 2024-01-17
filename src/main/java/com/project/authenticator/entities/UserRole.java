package com.project.authenticator.entities;

import org.springframework.security.core.userdetails.UserDetails;

public enum Role{
	ADMIN("admin"),
	USER("user");
	
	private String role;
	
	Role(String role){
		this.role = role;
	}
	
	String getRole() {
		return role;
	}
}
