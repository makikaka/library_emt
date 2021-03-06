package com.example.LibraryEmtBackend.controller;

import com.example.LibraryEmtBackend.model.Author;
import com.example.LibraryEmtBackend.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> GetAllBooks() {
        return authorService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Author> save(@RequestParam(required = false) Long id,
                                       @RequestParam String name,
                                       @RequestParam String surname,
                                       @RequestParam Long countryId
    ) {
        if (id == null) {
            return this.authorService.save(name, surname, countryId)
                    .map(author -> ResponseEntity.ok().body(author))
                    .orElseGet(() -> ResponseEntity.badRequest().build());
        } else {
            return this.authorService.edit(id, name, surname, countryId)
                    .map(author -> ResponseEntity.ok().body(author))
                    .orElseGet(() -> ResponseEntity.badRequest().build());
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        this.authorService.deleteById(id);
    }
}
