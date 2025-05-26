package com.example.umc2025.validation.validator;

import com.example.umc2025.apiPayload.Code.status.ErrorStatus;
import com.example.umc2025.validation.annotation.CheckPage;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Check;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CheckPageValidator implements ConstraintValidator<CheckPage, List<Long>> {
    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> value, ConstraintValidatorContext context) {

        //들어오는 수는 1 이상이어야 한다.
        boolean bool = value.stream()
                .anyMatch(v -> v < 1);

        if (bool) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_NUMBER_ERROR.toString()).addConstraintViolation();
        } else {
            //첫 페이지는 0부터 시작한다.
            value.stream().map(v -> v - 1).toList();
        }
        return false;
    }
}
