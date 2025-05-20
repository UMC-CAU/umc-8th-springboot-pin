package com.example.umc2025.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class RatingResponseDTO {

    @Builder
    @Getter
    public static class JoinResultDTO {
        Long ratingId;
        LocalDateTime createdAt;
    }



}
