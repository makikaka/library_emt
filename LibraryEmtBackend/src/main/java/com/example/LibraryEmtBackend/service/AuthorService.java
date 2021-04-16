package com.example.LibraryEmtBackend.service;

import com.example.LibraryEmtBackend.model.Author;
import com.example.LibraryEmtBackend.model.Book;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();
}
