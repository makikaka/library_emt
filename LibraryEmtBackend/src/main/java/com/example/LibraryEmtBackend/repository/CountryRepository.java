package com.example.LibraryEmtBackend.repository;

import com.example.LibraryEmtBackend.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
