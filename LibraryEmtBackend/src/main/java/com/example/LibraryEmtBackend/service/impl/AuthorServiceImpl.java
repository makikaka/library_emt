package com.example.LibraryEmtBackend.service.impl;

import com.example.LibraryEmtBackend.model.Author;
import com.example.LibraryEmtBackend.model.Book;
import com.example.LibraryEmtBackend.model.exceptions.AuthorNotFoundException;
import com.example.LibraryEmtBackend.model.exceptions.BookNotFoundException;
import com.example.LibraryEmtBackend.repository.AuthorRepository;
import com.example.LibraryEmtBackend.repository.BookRepository;
import com.example.LibraryEmtBackend.repository.CountryRepository;
import com.example.LibraryEmtBackend.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {return this.authorRepository.findAll(); }

    @Override
    public Optional<Author> findById(Long id) {return this.authorRepository.findById(id);}

    @Override
    public Optional<Author> save(String name,
                                 String surname,
                               Long countryId) {
        Author newAuthor = new Author();
        newAuthor.setName(name);
        newAuthor.setSurname(surname);
        newAuthor.setCountry(countryRepository.findById(countryId).get());
        return Optional.of(this.authorRepository.save(newAuthor));}

    @Override
    public Optional<Author> edit(Long id,
                               String name,
                               String surname,
                               Long countryId) {
        Author authorDb = this.authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));
        authorDb.setName(name);
        authorDb.setSurname(surname);
        authorDb.setCountry(countryRepository.findById(countryId).get());
        return Optional.of(this.authorRepository.save(authorDb));
    }

    @Override
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);
    }
}