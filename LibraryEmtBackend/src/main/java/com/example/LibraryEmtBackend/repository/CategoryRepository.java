package com.example.LibraryEmtBackend.repository;

import com.example.LibraryEmtBackend.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Genre, Long> {
    List<Genre> findAll();
}
