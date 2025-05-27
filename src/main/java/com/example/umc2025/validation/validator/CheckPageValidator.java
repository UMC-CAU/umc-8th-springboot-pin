package com.example.umc2025.validation.validator;

import com.example.umc2025.apiPayload.Code.status.ErrorStatus;
import com.example.umc2025.apiPayload.exception.GeneralException;
import com.example.umc2025.validation.annotation.CheckPage;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Check;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.List;

@Component
public class CheckPageValidator implements HandlerMethodArgumentResolver {

//    @Override
//    public boolean isValid(Integer value, ConstraintValidatorContext context) {
//        if (value == null || value <= 0) {
//            context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_NUMBER_ERROR.toString())
//                    .addConstraintViolation();
//            return false;
//        }
//        return true;
//    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CheckPage.class)
                && parameter.getParameterType().equals(Integer.class);

    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String paramValue = webRequest.getParameter("page");

        if (paramValue == null) {
            return 0;
        }

        int page = Integer.parseInt(paramValue);

        if (page <= 0) {
            throw new GeneralException(ErrorStatus.PAGE_NUMBER_ERROR);
        }

        return page - 1; // ✔ 여기서 값 변경!
    }
}
