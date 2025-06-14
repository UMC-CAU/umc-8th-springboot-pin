package com.example.umc2025.web.controller;

import com.example.umc2025.apiPayload.ApiResponse;
import com.example.umc2025.domain.Rating;
import com.example.umc2025.service.RatingService.RatingService;
import com.example.umc2025.web.converter.RatingConverter;
import com.example.umc2025.web.dto.RatingRequestDTO;
import com.example.umc2025.web.dto.RatingResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService ratingService;

    @PostMapping("/create")
    public ApiResponse<RatingResponseDTO.JoinResultDTO> createRating(@Valid @RequestBody RatingRequestDTO.CreateRating request) {
        Rating rating = ratingService.createRating(request);
        return ApiResponse.onSuccess(RatingConverter.toCreateResultDTO(rating));
    }
}
