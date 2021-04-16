package com.example.LibraryEmtBackend.service;

import com.example.LibraryEmtBackend.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> save(String name,
                        Long genreId,
                        Long authorId,
                        int availableCopies);

    Optional<Book> edit(Long id,
                        String name,
                        Long genreId,
                        Long authorId,
                        int availableCopies);

    Optional<Book> takeBook(Long id);

    Page<Book> findAllWithPagination(Pageable pageable);

    void deleteById(Long id);
}
