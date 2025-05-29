package com.example.umc2025.web.controller;

import com.example.umc2025.apiPayload.ApiResponse;
import com.example.umc2025.domain.Member;
import com.example.umc2025.domain.Rating;
import com.example.umc2025.domain.mapping.MemberMission;
import com.example.umc2025.service.MemberService.MemberCommandService;
import com.example.umc2025.validation.annotation.CheckPage;
import com.example.umc2025.web.converter.MemberConverter;
import com.example.umc2025.web.dto.MemberRequestDTO;
import com.example.umc2025.web.dto.MemberResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/join")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @GetMapping("/{memberId}/rating")
    @Operation(summary = "특정 맴버의 리뷰 목록 조회 API", description = "특정 맴버의 리뷰를 조회합니다. paging 포함")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "member 아이디, path variable 입니다!")
    })
    public ApiResponse<MemberResponseDTO.myRatingListResultDTO> getMyRatingListDTO(@PathVariable(name = "memberId") Long memberId, @CheckPage @RequestParam("page") Integer page) {
        Page<Rating> ratingList = memberCommandService.getRatingList(memberId, page);
        return ApiResponse.onSuccess(MemberConverter.toMyRatingListResultDTO(ratingList));
    }

    @GetMapping("/{memberId}/memberMission/tring")
    @Operation(summary = "특정 맴버의 도전 중인 미션 목록 조회 API", description = "특정 맴버의 도전 중인 미션 목록을 조회합니다. paging 포함")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "member 아이디, path variable 입니다!")
    })
    public ApiResponse<MemberResponseDTO.tryingMemberMissionListDTO> getTryingMemberMissionListDTO(@PathVariable(name = "memberId") Long memberId, @CheckPage @RequestParam("page") Integer page) {
        Page<MemberMission> tryingMissionList = memberCommandService.getTryingMissionMissionList(memberId, page);
        return ApiResponse.onSuccess(MemberConverter.toMemberMissionListDTO(tryingMissionList));
    }
}
