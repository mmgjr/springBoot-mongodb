package com.muciomgjr.learningmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.muciomgjr.learningmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	

}
