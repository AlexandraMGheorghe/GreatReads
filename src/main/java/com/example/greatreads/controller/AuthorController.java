package com.example.greatreads.controller;

import com.example.greatreads.dto.BookDTO;
import com.example.greatreads.model.Book;
import com.example.greatreads.model.enums.BookStatus;
import com.example.greatreads.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final BookService bookService;

    @Autowired
    public AuthorController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('Author')")
    public ResponseEntity<Book> addBook(@RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.addNewBook(bookDTO, BookStatus.PENDING));
    }

    @GetMapping("/books")
    @PreAuthorize("hasAuthority('Author')")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/books/{category}")
    @PreAuthorize("hasAuthority('Author')")
    public ResponseEntity<List<Book>> getBooksByGenre(@PathVariable String category) {
        List<Book> books = bookService.getAllPublishedByGenre(category);
        return ResponseEntity.ok(books);
    }


    @GetMapping("/published")
    @PreAuthorize("hasAuthority('Author')")
    public ResponseEntity<List<Book>> getPublishedBooks() {
        List<Book> books = bookService.getPublishedBooks();
        return ResponseEntity.ok(books);
    }
}