package com.example.umc2025.apiPayload.exception;

import com.example.umc2025.apiPayload.Code.BaseErrorCode;
import com.example.umc2025.apiPayload.Code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus() {
        return this.code.getReasonHttpStatus();
    }
}
