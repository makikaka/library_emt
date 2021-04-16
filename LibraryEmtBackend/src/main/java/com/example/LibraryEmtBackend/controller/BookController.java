package com.example.LibraryEmtBackend.controller;

import com.example.LibraryEmtBackend.model.Book;
import com.example.LibraryEmtBackend.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public List<Book> GetAllBooks() {
        return bookService.findAll();
    }

    @GetMapping
    public List<Book> findAllWithPagination(Pageable pageable) {
        return this.bookService.findAllWithPagination(pageable).getContent();
    }

    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestParam(required = false) Long id,
                                     @RequestParam String name,
                                     @RequestParam Long genreId,
                                     @RequestParam Long authorId,
                                     @RequestParam int availableCopies
    ) {
        if (id == null) {
            return this.bookService.save(name, genreId, authorId, availableCopies)
                    .map(book -> ResponseEntity.ok().body(book))
                    .orElseGet(() -> ResponseEntity.badRequest().build());
        } else {
            return this.bookService.edit(id, name, genreId, authorId, availableCopies)
                    .map(book -> ResponseEntity.ok().body(book))
                    .orElseGet(() -> ResponseEntity.badRequest().build());
        }
    }

    @PostMapping("/take-book/{id}")
    public ResponseEntity<Book> takeBook(@PathVariable Long id) {
        return this.bookService.takeBook(id).map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        this.bookService.deleteById(id);
    }

}
