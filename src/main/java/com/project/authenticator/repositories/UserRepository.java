package com.project.authenticator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.authenticator.entities.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

	UserDetails findByLogin(String login);
}
