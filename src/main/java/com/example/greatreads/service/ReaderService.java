package com.example.greatreads.service;
import com.example.greatreads.exceptions.RecordNotFoundException;
import com.example.greatreads.model.Book;
import com.example.greatreads.model.Reader;
import com.example.greatreads.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;
    private final BookService bookService;

    public Book markAsRead(Long readerId, Long bookId) {
        Book readBook = bookService.getById(bookId);
        Reader reader = findById(readerId);

        reader.getReaderBooks().add(readBook);
        return readBook;
    }

    public Reader findById(Long readerId) {
        return readerRepository.findById(readerId).orElseThrow(
                () -> new RecordNotFoundException("No reader found for id " + readerId));
    }

    public Book addToWishlist(Long readerId, Long bookId) {
        Book wishedBook = bookService.getById(bookId);
        Reader reader = readerRepository.findById(readerId).orElseThrow(
                () -> new RecordNotFoundException("No reader found for id " + readerId));

        reader.getWishedBooks().add(wishedBook);
        return wishedBook;
    }
}