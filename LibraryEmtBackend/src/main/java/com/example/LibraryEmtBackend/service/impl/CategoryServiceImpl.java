package com.example.LibraryEmtBackend.service.impl;

import com.example.LibraryEmtBackend.model.Category;
import com.example.LibraryEmtBackend.repository.CategoryRepository;
import com.example.LibraryEmtBackend.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }
}
