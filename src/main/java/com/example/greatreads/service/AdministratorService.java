package com.example.greatreads.service;

import com.example.greatreads.exceptions.RecordNotFoundException;
import com.example.greatreads.model.Book;
import com.example.greatreads.model.enums.BookStatus;
import com.example.greatreads.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdministratorService {

    private final BookRepository bookRepository;

    public List<Book> getPendingBooks() {
        return bookRepository.findAllByStatus(BookStatus.PENDING);
    }

    public BookStatus updatePendingStatus(Long bookId, BookStatus status) {
        Book book = bookRepository.findById(bookId).orElseThrow(
                () -> new RecordNotFoundException("No book found for id " + bookId));
        book.setStatus(status);
        bookRepository.save(book);
        return status;
    }
}