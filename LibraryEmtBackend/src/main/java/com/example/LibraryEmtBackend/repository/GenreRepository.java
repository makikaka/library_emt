package com.example.LibraryEmtBackend.repository;

import com.example.LibraryEmtBackend.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
