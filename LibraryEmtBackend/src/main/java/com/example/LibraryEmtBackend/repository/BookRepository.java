package com.example.LibraryEmtBackend.repository;

import com.example.LibraryEmtBackend.model.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH)
    @Query("select b from Book b")
    List<Book> fetchAll();
}
