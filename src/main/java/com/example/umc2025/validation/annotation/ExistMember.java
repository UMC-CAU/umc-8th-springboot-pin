package com.example.umc2025.validation.annotation;

import com.example.umc2025.validation.validator.CategoriesExistValidator;
import com.example.umc2025.validation.validator.MemberExistValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MemberExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistMember {

    String message() default "존재하지 않는 스토어입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
