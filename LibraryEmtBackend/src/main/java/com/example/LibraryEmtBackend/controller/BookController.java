package com.example.LibraryEmtBackend.controller;

import com.example.LibraryEmtBackend.model.Book;
import com.example.LibraryEmtBackend.service.AuthorService;
import com.example.LibraryEmtBackend.service.BookService;
import com.mysql.cj.x.protobuf.Mysqlx;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestParam(required = false) Long id,
                                     @RequestParam String name,
                                     @RequestParam Long genreId,
                                     @RequestParam Long authorId,
                                     @RequestParam int availableCopies
    ) {
        if (id != null){
            return this.bookService.save(name, genreId, authorId, availableCopies)
                    .map(book -> ResponseEntity.ok().body(book))
                    .orElseGet(() -> ResponseEntity.badRequest().build());
        } else {
            return this.bookService.edit(id, name, genreId, authorId, availableCopies)
                    .map(book -> ResponseEntity.ok().body(book))
                    .orElseGet(() -> ResponseEntity.badRequest().build());
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        this.bookService.deleteById(id);
    }

}
