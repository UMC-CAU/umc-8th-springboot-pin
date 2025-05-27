package com.example.umc2025.config;

import com.example.umc2025.validation.annotation.CheckPage;
import com.example.umc2025.validation.validator.CheckPageValidator;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final CheckPageValidator checkPageValidator;

    public WebConfig(CheckPageValidator checkPageValidator) {
        this.checkPageValidator = checkPageValidator;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(checkPageValidator); // ✅ Validator를 등록
    }
}
