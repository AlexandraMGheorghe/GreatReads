package com.example.greatreads.controller;

import com.example.greatreads.dto.BookDTO;
import com.example.greatreads.model.Book;
import com.example.greatreads.model.enums.BookStatus;
import com.example.greatreads.service.AdministratorService;
import com.example.greatreads.service.BookService;
import com.example.greatreads.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {
    private final BookService bookService;
    private final ReviewService reviewService;
    private final AdministratorService administratorService;

    @Autowired
    public AdministratorController(BookService bookService, ReviewService reviewService, AdministratorService administratorService) {
        this.bookService = bookService;
        this.reviewService = reviewService;
        this.administratorService = administratorService;
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<Book> addBook(@RequestBody BookDTO bookDTO){
        return ResponseEntity.ok(bookService.addNewBook(bookDTO, BookStatus.APPROVED));
    }

    @PostMapping("/update/{bookId}")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<BookStatus> updatePendingBook(@PathVariable(name = "bookId") Long bookId,
                                                        @RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(administratorService.updatePendingStatus(bookId, bookDTO.getStatus()));
    }

    @DeleteMapping("/review/{reviewId}")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<?> deleteBookReview(@PathVariable(name = "reviewId") Long reviewId) {
        reviewService.deleteReview(reviewId);
        return ResponseEntity.ok("Review deleted");
    }

    @GetMapping("/books")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/books/{category}")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<List<Book>> getBooksByGenre(@PathVariable String category) {
        List<Book> books = bookService.getAllPublishedByGenre(category);
        return ResponseEntity.ok(books);
    }
}
