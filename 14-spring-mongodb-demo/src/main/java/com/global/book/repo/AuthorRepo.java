package com.global.book.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.global.book.entity.Author;
import java.util.List;


@Repository
public interface AuthorRepo extends MongoRepository<Author, String>{
	@Query(value = "{email:'?0'}", fields = "{'name':1, 'id':1}")
	Author findByAuthorByEmail(String email);
}
