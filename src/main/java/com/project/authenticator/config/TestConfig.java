package com.project.authenticator.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project.authenticator.entities.Product;
import com.project.authenticator.repositories.ProductRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Product p1 = new Product(null, "Arroz",3.5);
		Product p2 = new Product(null, "Feijão",8.5);
		Product p3 = new Product(null, "Milho",2.5);
		Product p4 = new Product(null, "Carne",30.0);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
	}	
	

}
