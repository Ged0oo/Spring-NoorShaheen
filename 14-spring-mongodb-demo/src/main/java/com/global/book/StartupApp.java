package com.global.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.global.book.repo.AuthorRepo;

@Component 
public class StartupApp implements CommandLineRunner {

    @Autowired
    private AuthorRepo authorRepo;
    
    @Override
    public void run(String... args) throws Exception {
        try {
            long count = authorRepo.count();
            
            System.out.println("==========================================");
            System.out.println("✅ CONNECTION SUCCESSFUL!");
            System.out.println("Current Author count in Atlas: " + count);
            System.out.println("==========================================");
            
        } catch (Exception e) {
            System.err.println("==========================================");
            System.err.println("❌ CONNECTION FAILED!");
            System.err.println("Error: " + e.getMessage());
            System.err.println("==========================================");
        }
    }
}