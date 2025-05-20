package com.example.umc2025.apiPayload.exception.handler;

import com.example.umc2025.apiPayload.Code.BaseErrorCode;
import com.example.umc2025.apiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {

    public MemberHandler(BaseErrorCode code) {
        super(code);
    }
}
