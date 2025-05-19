package com.example.umc2025.apiPayload.exception.handler;

import com.example.umc2025.apiPayload.Code.BaseErrorCode;
import com.example.umc2025.apiPayload.exception.GeneralException;

public class RatingHandler extends GeneralException {
    public RatingHandler(BaseErrorCode code) {
        super(code);
    }
}
