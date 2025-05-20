package com.example.umc2025.validation.validator;

import com.example.umc2025.apiPayload.Code.status.ErrorStatus;
import com.example.umc2025.repository.MemberRepository;
import com.example.umc2025.validation.annotation.ExistMember;
import com.example.umc2025.validation.annotation.ExistStore;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MemberExistValidator implements ConstraintValidator<ExistMember, Long> {

    private final MemberRepository memberRepository;
    @Override
    public void initialize(ExistMember constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

//    @Override
//    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
//        boolean isValid = values.stream()
//                .allMatch(value -> memberRepository.existsById(value));
//
//        if (!isValid) {
//            context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_NOT_FOUND.toString()).addConstraintViolation();
//
//        }
//
//        return false;
//    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        // null은 다른 어노테이션 (@NotNull)로 처리하도록 허용
        if (value == null) return true;

        boolean exists = memberRepository.existsById(value);

        if (!exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("존재하지 않는 회원입니다.")
                    .addConstraintViolation();
        }

        return exists;
    }
}
