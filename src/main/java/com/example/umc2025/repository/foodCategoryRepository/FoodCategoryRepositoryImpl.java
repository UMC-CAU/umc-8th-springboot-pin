package com.example.umc2025.repository.foodCategoryRepository;

import com.example.umc2025.apiPayload.Code.status.ErrorStatus;
import com.example.umc2025.apiPayload.exception.handler.FoodCategoryHandler;
import com.example.umc2025.domain.FoodCategory;
import com.example.umc2025.domain.Member;
import com.example.umc2025.domain.mapping.MemberPrefer;
import com.example.umc2025.repository.MemberRepository;
import com.example.umc2025.web.converter.MemberConverter;
import com.example.umc2025.web.converter.MemberPreferConverter;
import com.example.umc2025.web.dto.MemberRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class FoodCategoryRepositoryImpl implements FoodCategoryRepositoryCustom {

    private final MemberRepository memberRepository;


}
