package com.global.book.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.global.book.entity.Book;
import com.global.book.repository.BookRepo;


@Service
public class BookService {

    private final BookRepo bookRepo;
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }


    public Book findById(Long id) {
        return bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }


    public List<Book> findAll() {
        return bookRepo.findAll();
    }


    public Book insert(Book book) {
        return bookRepo.save(book);
    }


    public Book update(Book book) {
        Book old = findById(book.getId());
        if(book.getName() != null) old.setName(book.getName());
        if(book.getPrice() != null) old.setPrice(book.getPrice());
        if(book.getAuthor() != null) old.setAuthor(book.getAuthor());
        return bookRepo.save(old);
    }

    
    public void deleteById(Long id) {
        if (!bookRepo.existsById(id)) {
            throw new RuntimeException("Book not found with id: " + id);
        }
        bookRepo.deleteById(id);
    }
    
    @Transactional
    public void deleteAllByAuthorId(Long authorId) {
        bookRepo.deleteAllByAuthorId(authorId);
    }
}