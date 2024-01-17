package com.project.authenticator.entities;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS")
public class Users implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String password;
	private UserRole role;
	
	public Users() {
		
	}
	
	public Users(Long id, String login, String password, UserRole role) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.role = role;
	}
	
	public Users(String login, String password, UserRole role) {
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
	
	

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", login=" + login + ", password=" + password + ", role=" + role + "]";
	}


	//verifica as roles dos usuários para permitir as requisições
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		if(this.role.equals(UserRole.ADMIN)) {
			return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), 
				new SimpleGrantedAuthority("ROLE_USER"));
		}
		else {
			return List.of(new SimpleGrantedAuthority("ROLE_USER"));
		}
	}
	
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
