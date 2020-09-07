package com.muciomgjr.learningmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.muciomgjr.learningmongo.domain.Post;
import com.muciomgjr.learningmongo.domain.User;
import com.muciomgjr.learningmongo.dto.AuthorDTO;
import com.muciomgjr.learningmongo.dto.CommentDTO;
import com.muciomgjr.learningmongo.repository.PostRepository;
import com.muciomgjr.learningmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		
		User anna = new User(null, "Anna Silva", "annas@gmail.com");
		User pedro = new User(null, "Pedro Oliveira", "pedroli@gmail.com");
		User lucas = new User(null, "Lucas Amaral", "lucasAmaral@gmail.com");
		
		userRepository.saveAll(Arrays.asList(anna, pedro, lucas));

		postRepository.deleteAll();
		
		Post post1 = new Post(null, sdf.parse("21/03/2019"), "Partiu viagem", "Vou sair para festa. Boa noite!", new AuthorDTO(anna));
		Post post2 = new Post(null, sdf.parse("05/03/2020"), "Ajuda com Programação", "Alguém sabe tutoriais e livros sobre Angular com JAVA?", new AuthorDTO(anna));
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("15/03/2019"), new AuthorDTO(pedro));
		CommentDTO c2 = new CommentDTO("Aproveite!", sdf.parse("22/03/2017"), new AuthorDTO(anna));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("27/05/2019"), new AuthorDTO(lucas));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		anna.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(anna);
	}
	
	

}
