package com.example.umc2025.web.converter;

import com.example.umc2025.domain.Member;
import com.example.umc2025.domain.Rating;
import com.example.umc2025.domain.enums.Gender;
import com.example.umc2025.domain.mapping.MemberMission;
import com.example.umc2025.web.dto.MemberRequestDTO;
import com.example.umc2025.web.dto.MemberResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }

    public static MemberResponseDTO.myRatingListResultDTO toMyRatingListResultDTO(Page<Rating> ratingList) {

        List<MemberResponseDTO.myRatingResultDTO> ratingResultDTOS = ratingList.stream()
                .map(MemberConverter::toRatingResultDTO).collect(Collectors.toList());

        return MemberResponseDTO.myRatingListResultDTO.builder()
                .isFirst(ratingList.isFirst())
                .isLast(ratingList.isLast())
                .totalPage(ratingList.getTotalPages())
                .totalElements(ratingList.getTotalElements())
                .listSize(ratingList.getSize())
                .ratingList(ratingResultDTOS)
                .build();
    }

    public static MemberResponseDTO.myRatingResultDTO toRatingResultDTO(Rating rating) {
        return MemberResponseDTO.myRatingResultDTO.builder()
                .storeName(rating.getStore().getStoreName())
                .score(Float.valueOf(rating.getRate()))
                .createdAt(rating.getCreatedAt().toLocalDate())
                .body(rating.getRatingContent())
                .build();

    }

    public static MemberResponseDTO.tryingMemberMissionListDTO toMemberMissionListDTO(Page<MemberMission> memberMissions) {

        List<MemberResponseDTO.tryingMemberMissionDTO> collect = memberMissions.stream()
                .map(MemberConverter::tryingMemberMissionDTO).collect(Collectors.toList());

        return MemberResponseDTO.tryingMemberMissionListDTO.builder()
                .isFirst(memberMissions.isFirst())
                .isLast(memberMissions.isLast())
                .totalPage(memberMissions.getTotalPages())
                .totalElements(memberMissions.getTotalElements())
                .listSize(memberMissions.getSize())
                .tryingMissionDTOList(collect)
                .build();
    }

    public static MemberResponseDTO.tryingMemberMissionDTO tryingMemberMissionDTO(MemberMission memberMission) {
        return MemberResponseDTO.tryingMemberMissionDTO.builder()
                .missionName(memberMission.getMission().getMissionName())
                .content(memberMission.getMission().getMissionCertificationNumber())
                .status(memberMission.getStatus().name())
                .point(memberMission.getMission().getGotPoint())
                .build();
    }
}
