package com.example.LibraryEmtBackend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    private Genre genre;

    @ManyToOne
    private Author author;

    private int available_copies;

    public void takeBook(){
        available_copies--;
    }

    public Book() {
    }

    public Book(Long id, String name, Genre genre, Author author, int available_copies) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.available_copies = available_copies;
    }
}
