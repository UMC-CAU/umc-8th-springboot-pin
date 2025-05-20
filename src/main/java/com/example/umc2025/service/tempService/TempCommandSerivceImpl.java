package com.example.umc2025.service.tempService;

import com.example.umc2025.apiPayload.Code.status.ErrorStatus;
import com.example.umc2025.apiPayload.exception.handler.TempHandler;

public class TempCommandSerivceImpl implements TempCommandService{
    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}
