package com.example.LibraryEmtBackend.model.dto;

import com.example.LibraryEmtBackend.model.Book;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class BookPagesAndCount {
    private List<Book> pageBook;
    private long bookCount;

    public BookPagesAndCount(List<Book> pageBook, long bookCount) {
        this.pageBook = pageBook;
        this.bookCount = bookCount;
    }
}
