package com.example.umc2025.validation.validator;

import com.example.umc2025.apiPayload.Code.status.ErrorStatus;
import com.example.umc2025.repository.StoreRepository.StoreRepository;
import com.example.umc2025.validation.annotation.ExistStore;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<ExistStore, List<Long>> {

    private final StoreRepository storeRepository;

    @Override
    public void initialize(ExistStore constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {

        boolean isValid = values.stream()
                .allMatch(value -> storeRepository.existsById(value));

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString()).addConstraintViolation();

        }

        return false;
    }
}
