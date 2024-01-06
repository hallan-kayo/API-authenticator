package com.project.authenticator.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.authenticator.entities.Product;
import com.project.authenticator.repositories.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Transactional
	public List<Product> findAll(){
		List<Product> response = this.productRepository.findAll();
		return response;
	}
	
	public Product save(Product product) {
		return this.productRepository.save(product);
	}
}
