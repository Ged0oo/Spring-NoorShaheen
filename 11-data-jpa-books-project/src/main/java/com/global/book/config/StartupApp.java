package com.global.book.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.global.book.service.AuthorService;
import com.global.book.service.BookService;

@Component
public class StartupApp implements CommandLineRunner{
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private BookService bookService;

	@Override
	public void run(String... args) throws Exception{
		
	}
}
