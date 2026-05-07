package com.global.book.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.global.book.entity.Author;
import com.global.book.service.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getById(@PathVariable String id) {
        return ResponseEntity.ok(authorService.findById(id));
    }
    
    @GetMapping("/email/{email}")
    public ResponseEntity<Author> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(authorService.findAuthorByEmail(email));
    }


    @GetMapping
    public ResponseEntity<List<Author>> getAll() {
        return ResponseEntity.ok(authorService.findAll());
    }

    @PostMapping
    public ResponseEntity<Author> create(@RequestBody Author author) {
        return ResponseEntity.status(201).body(authorService.insert(author));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable String id, @RequestBody Author author) {
        author.setId(id);
        Author updated = authorService.update(author);
        return ResponseEntity.ok(updated);
    }
    
    @PutMapping("/custome")
    public ResponseEntity<Void> updateEmail(@RequestParam String name, @RequestParam String email, @RequestParam String phone) {
        authorService.updateEmail(name, email, phone);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        authorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}