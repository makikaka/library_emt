package com.example.LibraryEmtBackend.service.impl;

import com.example.LibraryEmtBackend.model.Book;
import com.example.LibraryEmtBackend.model.exceptions.BookNotFoundException;
import com.example.LibraryEmtBackend.repository.AuthorRepository;
import com.example.LibraryEmtBackend.repository.BookRepository;
import com.example.LibraryEmtBackend.repository.GenreRepository;
import com.example.LibraryEmtBackend.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, GenreRepository genreRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Book> findAll() {return this.bookRepository.findAll(); }

    @Override
    public Optional<Book> findById(Long id) {return this.bookRepository.findById(id);}

    @Override
    public Optional<Book> save(String name,
                               Long genreId,
                               Long authorId,
                               int availableCopies) {
        Book newBook = new Book();
        newBook.setName(name);
        newBook.setGenre(genreRepository.findById(genreId).get());
        newBook.setAvailable_copies(availableCopies);
        newBook.setAuthor(authorRepository.findById(authorId).get());
        return Optional.of(this.bookRepository.save(newBook));}

    @Override
    public Optional<Book> edit(Long id,
                               String name,
                               Long genreId,
                               Long authorId,
                               int availableCopies) {
        Book bookDb = this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        bookDb.setName(name);
        bookDb.setAuthor(authorRepository.findById(authorId).get());
        bookDb.setAvailable_copies(availableCopies);
        bookDb.setGenre(genreRepository.findById(id).get());
        return Optional.of(this.bookRepository.save(bookDb));
    }

    public Optional<Book> takeBook(Long id) {
        Book bookDb = this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        bookDb.takeBook();
        return Optional.of(this.bookRepository.save(bookDb));
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }
}
