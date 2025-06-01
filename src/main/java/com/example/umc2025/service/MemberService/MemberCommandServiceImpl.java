package com.example.umc2025.service.MemberService;

import com.example.umc2025.apiPayload.Code.status.ErrorStatus;
import com.example.umc2025.apiPayload.exception.handler.FoodCategoryHandler;
import com.example.umc2025.apiPayload.exception.handler.MemberHandler;
import com.example.umc2025.config.security.jwt.JwtTokenProvider;
import com.example.umc2025.domain.FoodCategory;
import com.example.umc2025.domain.Member;
import com.example.umc2025.domain.Rating;
import com.example.umc2025.domain.enums.MissionStatus;
import com.example.umc2025.domain.mapping.MemberMission;
import com.example.umc2025.domain.mapping.MemberPrefer;
import com.example.umc2025.repository.MemberRepository;
import com.example.umc2025.repository.foodCategoryRepository.FoodCategoryRepository;
import com.example.umc2025.repository.memberMissionRepository.MemberMissionRepository;
import com.example.umc2025.repository.ratingRepository.RatingRepository;
import com.example.umc2025.web.converter.MemberConverter;
import com.example.umc2025.web.converter.MemberPreferConverter;
import com.example.umc2025.web.dto.MemberRequestDTO;
import com.example.umc2025.web.dto.MemberResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final RatingRepository ratingRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);

        newMember.encodePassword(passwordEncoder.encode(request.getPassword()));
        log.info(newMember.getPassword());

        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }

    @Override
    public Member findById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
    }

    @Override
    public Page<Rating> getRatingList(Long memberId, Integer page) {

        Member member = memberRepository.findById(memberId).get();
        Page<Rating> allByMember = ratingRepository.findAllByMember(member, PageRequest.of(page, 10));

        return allByMember;
    }

    @Override
    public Page<MemberMission> getTryingMissionMissionList(Long memberId, Integer page) {

        Member member = memberRepository.findById(memberId).get();
        Page<MemberMission> allByMemberAndStatus = memberMissionRepository.findAllByMemberAndStatus(member, MissionStatus.TRYING, PageRequest.of(page, 10));
        return allByMemberAndStatus;

    }

    @Override
    public MemberResponseDTO.LoginResultDTO loginMember(MemberRequestDTO.LoginRequestDTO request) {
        log.info("loginMember");
        Member member = memberRepository.findByEmail(request.getEmail())
                .orElseThrow(()-> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        if(!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new MemberHandler(ErrorStatus.INVALID_PASSWORD);
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                member.getEmail(), null,
                Collections.singleton(() -> member.getRole().name())
        );

        String accessToken = jwtTokenProvider.generateToken(authentication);

        return MemberConverter.toLoginResultDTO(
                member.getId(),
                accessToken
        );
    }

    @Override
    @Transactional(readOnly = true)
    public MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request){
        Authentication authentication = jwtTokenProvider.extractAuthentication(request);
        String email = authentication.getName();

        Member member = memberRepository.findByEmail(email)
                .orElseThrow(()-> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        return MemberConverter.toMemberInfoDTO(member.getName(), member.getEmail(), member.getGender().toString());
    }
}
