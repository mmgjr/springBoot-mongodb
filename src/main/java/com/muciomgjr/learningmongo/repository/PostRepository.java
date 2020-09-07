package com.muciomgjr.learningmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.muciomgjr.learningmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	

}
