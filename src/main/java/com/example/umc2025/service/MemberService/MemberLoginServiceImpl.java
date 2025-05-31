package com.example.umc2025.service.MemberService;

import com.example.umc2025.config.security.jwt.GoogleClient;
import com.example.umc2025.config.security.jwt.JwtTokenProvider;
import com.example.umc2025.config.security.jwt.google.GoogleAccountProfileResponse;
import com.example.umc2025.domain.Member;
import com.example.umc2025.domain.enums.SocialType;
import com.example.umc2025.repository.MemberRepository;
import com.example.umc2025.web.converter.MemberConverter;
import com.example.umc2025.web.dto.MemberResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberLoginServiceImpl implements MemberLoginService {

    private final GoogleClient googleClient;
    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public MemberResponseDTO.LoginResultDTO oauthLoginGoogle(String code) {

        //google에서 유저 정보를 가져온다
        GoogleAccountProfileResponse profile = googleClient.getGoogleAccountProfile(code);
        String email = profile.getEmail();

        //해당 이메일의 존재 여부를 확인한다. 있으면 트큰 발행, 없으면 회원가입
        Member member = memberRepository.findByEmail(email)
                .orElseGet(() -> {
                    Member newMember = Member.builder()
                            .email(profile.getEmail())
                            .name(profile.getName())
                            .socialType(SocialType.GOOGLE)
                            .build();
                    return memberRepository.save(newMember);
                });

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
}
