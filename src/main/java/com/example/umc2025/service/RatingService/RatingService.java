package com.example.umc2025.service.RatingService;


import com.example.umc2025.domain.Rating;
import com.example.umc2025.web.dto.RatingRequestDTO;

public interface RatingService {

    public Rating createRating(RatingRequestDTO.CreateRating request);
}
