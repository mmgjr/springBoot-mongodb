package com.muciomgjr.learningmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.muciomgjr.learningmongo.domain.User;
import com.muciomgjr.learningmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User anna = new User(null, "Anna Silva", "annas@gmail.com");
		User pedro = new User(null, "Pedro Oliveira", "pedroli@gmail.com");
		User lucas = new User(null, "Lucas Amaral", "lucasAmaral@gmail.com");
		
		userRepository.saveAll(Arrays.asList(anna, pedro, lucas));
	}
	
	

}
