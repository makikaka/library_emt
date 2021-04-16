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
}
