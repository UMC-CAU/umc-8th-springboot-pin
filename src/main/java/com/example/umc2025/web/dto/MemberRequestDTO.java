package com.example.umc2025.web.dto;

import com.example.umc2025.validation.annotation.ExistCategory;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto{
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @NotBlank
        String password;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        @Size(min = 5, max = 12)
        String address;
        @Size(min = 5, max = 12)
        String specAddress;
        @ExistCategory
        List<Long> preferCategory;
        @Email
        String eamil;
    }
}
