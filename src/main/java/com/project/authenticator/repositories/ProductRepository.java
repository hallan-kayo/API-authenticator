package com.project.authenticator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.authenticator.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
