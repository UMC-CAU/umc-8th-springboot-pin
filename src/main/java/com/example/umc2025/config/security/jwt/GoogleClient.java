package com.example.umc2025.config.security.jwt;

import com.example.umc2025.apiPayload.Code.status.ErrorStatus;
import com.example.umc2025.apiPayload.exception.handler.MemberHandler;
import com.example.umc2025.config.security.jwt.google.GoogleAccessTokenRequest;
import com.example.umc2025.config.security.jwt.google.GoogleAccessTokenResponse;
import com.example.umc2025.config.security.jwt.google.GoogleAccountProfileResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.security.auth.login.LoginException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GoogleClient {

    @Value("${google.client-id}")
    private String clientId;
    @Value("${google.client-secret}")
    private String clientSecret;
    @Value("${google.redirect-uri}")
    private String redirectUri;
    @Value("${google.authorization-grant-type}")
    private String authorizationCode;
    @Value("${google.url.access-token}")
    private String accessTokenUrl;
    @Value("${google.url.profile}")
    private String profileUrl;

    //spring의 http 클라이언트.
    //외부 서버에 데이터를 보내고 응답을 받는다.
    private final RestTemplate restTemplate;

    public GoogleAccountProfileResponse getGoogleAccountProfile(final String code) {
        final String accessToken = requestGoogleAccessToken(code);
        return requestGoogleAccountProfile(accessToken);
    }

    //구글 서버에 가서 사용자 정보를 바탕으로 토큰을 받는다.
    private String requestGoogleAccessToken(final String code) {
        final String decodedCode = URLDecoder.decode(code, StandardCharsets.UTF_8);
        final HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        final HttpEntity<GoogleAccessTokenRequest> httpEntity = new HttpEntity<>(
                new GoogleAccessTokenRequest(decodedCode, clientId, clientSecret, redirectUri, authorizationCode),
                headers
        );
        final GoogleAccessTokenResponse response = restTemplate.exchange(
                accessTokenUrl, HttpMethod.POST, httpEntity, GoogleAccessTokenResponse.class
        ).getBody();

        return Optional.ofNullable(response)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.NOT_FOUND_GOOGLE_ACCESS_TOKEN_RESPONSE))
                .getAccessToken();
    }

    //구글이 준 토큰을 가지고 구글에 저장된 사용자의 데이터를 가져온다. (이 데이터를 바탕으로 저장하거나(회원가입) 기존 회원 찾거나(로그인))
    private GoogleAccountProfileResponse requestGoogleAccountProfile(final String accessToken) {
        final HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
        final HttpEntity<GoogleAccessTokenRequest> httpEntity = new HttpEntity<>(headers);
        return restTemplate.exchange(profileUrl, HttpMethod.GET, httpEntity, GoogleAccountProfileResponse.class)
                .getBody();
    }

}
