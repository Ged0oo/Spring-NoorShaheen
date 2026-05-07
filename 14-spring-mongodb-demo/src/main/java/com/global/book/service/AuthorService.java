package com.global.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.global.book.entity.Author;
import com.global.book.repo.AuthorRepo;
import com.global.book.repo.CustomeAuthorRepo;

@Service
public class AuthorService extends BaseService<Author, AuthorRepo> {

    private final AuthorRepo authorRepo;
    
    @Autowired
    private CustomeAuthorRepo customeAuthorRepo;
    
    public AuthorService(AuthorRepo authorRepo) {
        super(authorRepo);
        this.authorRepo = authorRepo;
    }

    @Override
    protected String getEntityName() {
        return "Author";
    }
    
    public Author findAuthorByEmail(String email) {
    	return authorRepo.findByAuthorByEmail(email);
    }

    @Override
    public Author insert(Author author) {
        if (author.getName() == null || author.getName().isEmpty()) {
            throw new RuntimeException("Author Name is Required.");
        }
        return super.insert(author);
    }

    public Author update(Author author) {
        Author existing = findById(author.getId()); 
        
        if (author.getName() != null) existing.setName(author.getName());
        if (author.getPhone() != null) existing.setPhone(author.getPhone());
        if (author.getEmail() != null) existing.setEmail(author.getEmail());
        
        return repo.save(existing);
    }
    
    public void updateEmail(String name, String email, String phone) {
    	customeAuthorRepo.updateEmail(name, email, phone);
    }
}