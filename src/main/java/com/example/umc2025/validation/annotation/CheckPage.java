package com.example.umc2025.validation.annotation;

import com.example.umc2025.validation.validator.CheckPageValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckPageValidator.class)   //지정된 클래스를 통해 대상을 검증한다.
@Target( {ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER} )    //어노테이션의 적용 범위.
@Retention(RetentionPolicy.RUNTIME)     //어노테이션의 생명 주기. runtime인 경우에만 작용된다.
public @interface CheckPage {

    String message() default "존재하지 않는 맴버입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
