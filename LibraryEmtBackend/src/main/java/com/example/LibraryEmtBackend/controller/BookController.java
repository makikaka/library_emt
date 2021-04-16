package com.example.LibraryEmtBackend.controller;

import com.example.LibraryEmtBackend.model.Book;
import com.example.LibraryEmtBackend.service.AuthorService;
import com.example.LibraryEmtBackend.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public List<Book> GetAllBooks() {
        return bookService.findAll();
    }
}
