package com.example.LibraryEmtBackend.service;

import com.example.LibraryEmtBackend.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();


    Optional<Author> save(String name,
                          String surname,
                          Long countryId);

    Optional<Author> edit(Long id,
                          String name,
                          String surname,
                          Long countryId);

    void deleteById(Long id);
}
