package com.example.umc2025.config.security.jwt.google;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class GoogleAccountProfileResponse {

    private String id;
    private String email;

    @JsonProperty("verified_email")
    private boolean verifiedEmail;

    private String name;

    @JsonProperty("given_name")
    private String givenName;

    @JsonProperty("family_name")
    private String familyName;

    private String picture;
    private String locale;
}
