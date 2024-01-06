package com.project.authenticator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.authenticator.entities.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

}
