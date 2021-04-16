package com.example.LibraryEmtBackend.controller;

import com.example.LibraryEmtBackend.model.Author;
import com.example.LibraryEmtBackend.model.Book;
import com.example.LibraryEmtBackend.repository.AuthorRepository;
import com.example.LibraryEmtBackend.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/authors")
public class AuthorController {
    private final BookRepository bookService;
    private final AuthorRepository authorService;

    public AuthorController(BookRepository bookService, AuthorRepository authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> GetAllBooks() {
        return authorService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.bookService.deleteById(id);
        if(this.bookService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
