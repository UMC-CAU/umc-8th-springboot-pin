package com.example.umc2025.web.converter;

import com.example.umc2025.domain.Rating;
import com.example.umc2025.web.dto.RatingRequestDTO;
import com.example.umc2025.web.dto.RatingResponseDTO;

public class RatingConverter {

    public static Rating toRating(RatingRequestDTO.CreateRating request) {

        return Rating.builder()
                .rate(request.getRate())
                .ratingContent(request.getRatingContent())
                .build();
    }

    public static RatingResponseDTO.JoinResultDTO toCreateResultDTO(Rating rating) {
        return RatingResponseDTO.JoinResultDTO.builder()
                .ratingId(rating.getId())
                .createdAt(rating.getCreatedAt())
                .build();
    }
}
