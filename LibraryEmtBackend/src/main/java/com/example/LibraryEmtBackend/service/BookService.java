package com.example.LibraryEmtBackend.service;

import com.example.LibraryEmtBackend.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> save(Book book);

    Optional<Book> edit(Long id, Book book);

    void deleteById(Long id);
}
