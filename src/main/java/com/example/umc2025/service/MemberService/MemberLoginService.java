package com.example.umc2025.service.MemberService;

import com.example.umc2025.web.dto.MemberResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

public interface MemberLoginService {
    MemberResponseDTO.LoginResultDTO oauthLoginGoogle(String code);
}
