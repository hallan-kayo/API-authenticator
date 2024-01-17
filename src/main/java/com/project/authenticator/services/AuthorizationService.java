package com.project.authenticator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.authenticator.repositories.UserRepository;

@Service
public class AuthorizationService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	//Consulta os dados no banco quando recebe uma solicitação de autenticação
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.findByLogin(username);
	}

}
