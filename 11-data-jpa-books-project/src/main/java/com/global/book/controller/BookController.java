package com.global.book.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.global.book.entity.Book;
import com.global.book.entity.BookDto;
import com.global.book.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
    	Book book = bookService.findById(id);
    	
    	BookDto dto = new BookDto();
    	dto.setId(book.getId());
    	dto.setName(book.getName());
    	dto.setPrice(book.getPrice());
    	
        return ResponseEntity.ok(dto);
    }


    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book saved = bookService.insert(book);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        Book updated = bookService.update(book);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/author/{id}")
    public ResponseEntity<Void> deleteBooksByauthorId(@PathVariable Long id) {
        bookService.deleteAllByAuthorId(id);
        return ResponseEntity.noContent().build();
    }
}