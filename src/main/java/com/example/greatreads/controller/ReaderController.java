package com.example.greatreads.controller;

import com.example.greatreads.dto.ReviewDTO;
import com.example.greatreads.model.Book;
import com.example.greatreads.service.BookService;
import com.example.greatreads.service.ReaderService;
import com.example.greatreads.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reader")
public class ReaderController {

    private final ReaderService readerService;
    private final ReviewService reviewService;
    private final BookService bookService;

    @Autowired
    public ReaderController(ReaderService readerService,
                            ReviewService reviewService, BookService bookService) {
        this.readerService = readerService;
        this.reviewService = reviewService;
        this.bookService = bookService;
    }

    @GetMapping("/books")
    @PreAuthorize("hasAuthority('Reader')")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/books/{category}")
    @PreAuthorize("hasAuthority('Reader')")
    public ResponseEntity<List<Book>> getBooksByGenre(@PathVariable String category) {
        List<Book> books = bookService.getAllPublishedByGenre(category);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{readerId}/book/{bookId}")
    @PreAuthorize("hasAuthority('Reader')")
    public ResponseEntity<?> markBookAsRead(@PathVariable(name = "readerId") Long readerId,
                                            @PathVariable(name = "bookId") Long bookId) {
        return ResponseEntity.ok(readerService.markAsRead(readerId, bookId));
    }

    @GetMapping("/{readerId}/wishlist/{bookId}")
    @PreAuthorize("hasAuthority('Reader')")
    public ResponseEntity<?> addBookToWishlist(@PathVariable(name = "readerId") Long readerId,
                                               @PathVariable(name = "bookId") Long bookId) {
        return ResponseEntity.ok(readerService.addToWishlist(readerId, bookId));
    }

    @PostMapping("/{readerId}/review")
    @PreAuthorize("hasAuthority('Reader')")
    public ResponseEntity<?> addBookNewReview(@PathVariable(name = "readerId") Long readerId,
                                              @RequestBody ReviewDTO reviewDTO) {
        return ResponseEntity.ok(reviewService.addNewReview(readerId, reviewDTO));
    }

    @PostMapping("/{readerId}/review/{reviewId}")
    @PreAuthorize("hasAuthority('Reader')")
    public ResponseEntity<?> updateBookReview(@PathVariable(name = "readerId") Long readerId,
                                              @PathVariable(name = "reviewId") Long reviewId,
                                              @RequestBody ReviewDTO reviewDTO) {
        return ResponseEntity.ok(reviewService.updateReview(readerId, reviewId, reviewDTO));
    }
}