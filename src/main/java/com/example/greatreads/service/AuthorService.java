package com.example.greatreads.service;
import com.example.greatreads.exceptions.RecordNotFoundException;
import com.example.greatreads.model.User;
import com.example.greatreads.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class
AuthorService {

    private final UserRepository authorRepository;

    public User getById(Long authorId) {
        return authorRepository.findById(authorId).orElseThrow(() ->
                new RecordNotFoundException("No author found for id " + authorId));
    }
}