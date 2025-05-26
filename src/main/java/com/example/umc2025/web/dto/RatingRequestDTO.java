package com.example.umc2025.web.dto;

import com.example.umc2025.validation.annotation.ExistMember;
import com.example.umc2025.validation.annotation.ExistStore;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class RatingRequestDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class CreateRating {
        @NotNull
        @Min(0)
        @Max(5)
        Integer rate;

        String ratingContent;

        @NotNull
        Long missionId;

        @NotNull
        @ExistMember
        Long memberId;

        @NotNull
        @ExistStore
        Long storeId;
    }
}
