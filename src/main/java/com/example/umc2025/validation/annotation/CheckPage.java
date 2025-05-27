package com.example.umc2025.validation.annotation;

import com.example.umc2025.validation.validator.CheckPageValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {

    String message() default "존재하지 않는 맴버입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
