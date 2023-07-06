package com.example.greatreads.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Reader;
import java.time.LocalDateTime;

@Getter
@Setter
public class ReviewDTO {

    private Integer rating;
    private String comment;
    private Reader reader;
    private LocalDateTime publishedTimestamp;
}