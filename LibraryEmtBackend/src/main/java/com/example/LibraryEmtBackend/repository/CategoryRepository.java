package com.example.LibraryEmtBackend.repository;

import com.example.LibraryEmtBackend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
