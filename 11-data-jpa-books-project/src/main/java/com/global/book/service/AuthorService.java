package com.global.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.global.book.entity.Author;
import com.global.book.repository.AuthorRepo;

@Service
public class AuthorService {

    private final AuthorRepo authorRepo;
    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public Author findById(Long id) {
        return authorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));
    }
    
    public Author getById(Long id) {
    	return authorRepo.getById(id);
    }

    public List<Author> findAll() {
        return authorRepo.findAll();
    }

    public Author insert(Author author) {
    	if(author.getName() == null) {
    		throw new RuntimeException("Author Name is Required.");
    	}
        return authorRepo.save(author);
    }
    
    public List<Author> bulkInsert(List<Author> authors) {
        return authorRepo.saveAll(authors);
    }

    public Author update(Author author) {
        Author old = findById(author.getId());
        old.setName(author.getName());
        return authorRepo.save(old);
    }

    public void deleteById(Long id) {
        if (!authorRepo.existsById(id)) {
            throw new RuntimeException("Author not found with id: " + id);
        }
        authorRepo.deleteById(id);
    }
}