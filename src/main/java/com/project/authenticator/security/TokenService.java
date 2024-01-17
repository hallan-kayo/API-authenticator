package com.project.authenticator.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.project.authenticator.entities.Users;

@Service
public class TokenService {
	
	@Value("${api.security.token.secret}") //Localizado no application.properties
	private String secret;
	
	public String generationToken(Users user) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret); //Define o algoritmo usado no token
			String token = JWT.create()
					.withIssuer("Authentication") //Define quem está pedindo o token
					.withSubject(user.getLogin()) //Define o Usuário
					.withExpiresAt(expirationDate()) // Define quanto tempo até o token expirar
					.sign(algorithm); //faz a assinatura
			return token;
		}catch(JWTCreationException e) {
			throw new RuntimeException("Error generating token", e);
		}
	}
	
	public String validatetoken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret); //Define o algoritmo usado no token
			return JWT.require(algorithm)
					.withIssuer("Authentication") //verifica o requirinte
					.build()
					.verify(token) //valida o token
					.getSubject(); //Pega o subject definido no método de generation
		}catch(JWTVerificationException e) {
			return "";
		}
	}
	
	private Instant expirationDate() {
		//Pega a data e hora atuais, adiciona mais 2 horas e transforma em um Instant no timezone do Brasil
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}

}
