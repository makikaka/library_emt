package com.example.LibraryEmtBackend.service;

import com.example.LibraryEmtBackend.model.Genre;

import java.util.List;

public interface CategoryService {
    List<Genre> findAll();
}
