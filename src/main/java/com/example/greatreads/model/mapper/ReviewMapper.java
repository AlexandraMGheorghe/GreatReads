package com.example.greatreads.model.mapper;

import com.example.greatreads.dto.ReviewDTO;
import com.example.greatreads.model.Review;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateReviewFromDto(ReviewDTO dto, @MappingTarget Review entity);
}