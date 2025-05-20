package com.example.umc2025.service.RatingService;

import com.example.umc2025.apiPayload.Code.status.ErrorStatus;
import com.example.umc2025.apiPayload.exception.handler.MemberHandler;
import com.example.umc2025.apiPayload.exception.handler.MissionHandler;
import com.example.umc2025.apiPayload.exception.handler.RatingHandler;
import com.example.umc2025.apiPayload.exception.handler.StoreHandler;
import com.example.umc2025.domain.Member;
import com.example.umc2025.domain.Rating;
import com.example.umc2025.domain.Store;
import com.example.umc2025.repository.ratingRepository.RatingRepository;
import com.example.umc2025.service.MemberService.MemberCommandService;
import com.example.umc2025.service.StoreService.StoreQueryService;
import com.example.umc2025.web.converter.RatingConverter;
import com.example.umc2025.web.dto.RatingRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RatingServiceImpl implements RatingService{

    private final StoreQueryService storeQueryService;
    private final MemberCommandService memberComandService;
    private final RatingRepository ratingRepository;

    @Override
    @Transactional
    public Rating createRating(RatingRequestDTO.CreateRating request) {

        Rating newRating = RatingConverter.toRating(request);

        Store store = storeQueryService.findStore(request.getStoreId());

        Member member = memberComandService.findById(request.getMemberId());

        if (ratingRepository.existsByMemberIdAndStoreId(member.getId(), store.getId())) {
            throw new RatingHandler(ErrorStatus.DUPLICATE_RATING);
        }

        newRating.setStore(store);
        newRating.setMember(member);
        ratingRepository.save(newRating);

        return newRating;
    }
}
