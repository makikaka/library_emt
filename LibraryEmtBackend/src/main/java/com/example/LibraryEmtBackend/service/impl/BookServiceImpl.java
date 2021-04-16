package com.example.LibraryEmtBackend.service.impl;

import com.example.LibraryEmtBackend.model.Book;
import com.example.LibraryEmtBackend.model.exceptions.BookNotFoundException;
import com.example.LibraryEmtBackend.repository.AuthorRepository;
import com.example.LibraryEmtBackend.repository.BookRepository;
import com.example.LibraryEmtBackend.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {return this.bookRepository.findAll(); }

    @Override
    public Optional<Book> save(Book book) {
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> edit(Long id, Book book) {
        Book bookDb = this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        bookDb.name = book.name;
        bookDb.author = book.author;
        bookDb.genre = book.genre;
        bookDb.available_copies = book.available_copies;
        return Optional.of(this.bookRepository.save(bookDb));
    }

    public Optional<Book> takeBook(Long id, Book book) {
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
