package com.example.umc2025.apiPayload.Code.status;

import com.example.umc2025.apiPayload.Code.BaseErrorCode;
import com.example.umc2025.apiPayload.Code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // 가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),


    // 멤버 관려 에러
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),

    //FoodCategory 관련 에러
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.BAD_REQUEST, "FOODCATE4001", "존재하지 않는 카데고리입니다."),

    //Store
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "STORE4001", "존재하지 않는 스토어 입니다."),

    //Mission
    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "MISSION4001", "존재하지 않는 미션입니다"),
    DUPLICATE_MISSION(HttpStatus.CONFLICT, "MISSION4091", "이미 존재하는 미션입니다"),

    //Rating
    DUPLICATE_RATING(HttpStatus.CONFLICT, "RATING4091", "이미 리뷰를 남겼습니다"),

    //MemberMission
    MEMBERMISSION_EXIST(HttpStatus.CONFLICT, "MEMBERMISSION4002", "이미 존재합니다"),

    //page 관련 에러
    PAGE_NUMBER_ERROR(HttpStatus.BAD_REQUEST, "PAGE4001", "잘못된 페이지 요청입니다."),
    //test
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "이거는 테스트"),
    DISCORD_EXCPETION(HttpStatus.INTERNAL_SERVER_ERROR, "DISCORD5000", "DISCORD TEST"),

    //jet
    INVALID_TOKEN(HttpStatus.BAD_REQUEST, "JWT4001", "INVALID_TOKEN"),
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST, "JWT4002", "잘못된  비밀번호입니다."),
    NOT_FOUND_GOOGLE_ACCESS_TOKEN_RESPONSE(HttpStatus.NOT_FOUND, "JWT4003", "구글 클라이언트로부터 데이터를 불러오지 못했습니다");



    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}
