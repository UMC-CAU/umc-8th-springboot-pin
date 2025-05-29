package com.example.umc2025.config.security.jwt.google;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class GoogleAccessTokenResponse {
    @JsonProperty("access_token")
    private String accessToken;
}
