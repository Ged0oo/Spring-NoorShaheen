package com.global.book.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.global.book.entity.Author;
import com.global.book.entity.Book;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long>{
	@Override
	@EntityGraph(attributePaths = {"books"})
	@Query("SELECT DISTINCT a FROM Author a")
	List<Author> findAll();

}
