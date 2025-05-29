package com.example.umc2025.web.converter;

import com.example.umc2025.domain.Mission;
import com.example.umc2025.domain.Rating;
import com.example.umc2025.web.dto.StoreResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    public static StoreResponseDTO.RatingPreViewListDTO reviewPreViewListDTO(Page<Rating> rateList){
        List<StoreResponseDTO.RatingPreViewDTO> reviewPreViewDTOList = rateList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.RatingPreViewListDTO.builder()
                .isLast(rateList.isLast())
                .isFirst(rateList.isFirst())
                .totalPage(rateList.getTotalPages())
                .totalElements(rateList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static StoreResponseDTO.RatingPreViewDTO reviewPreViewDTO(Rating rating){
        return StoreResponseDTO.RatingPreViewDTO.builder()
                .ownerNickname(rating.getMember().getName())
                .score(Float.valueOf(rating.getRate()))
                .createdAt(rating.getCreatedAt().toLocalDate())
                .body(rating.getRatingContent())
                .build();
    }

    public static StoreResponseDTO.MissionPreviewListDTO missionPreviewListDTO(Page<Mission> missionList) {
        List<StoreResponseDTO.MissionPreviewDTO> missionPreviewDTOList = missionList.stream()
                .map(StoreConverter::missionPreviewDTO).collect(Collectors.toList());

        return StoreResponseDTO.MissionPreviewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionList.getSize())
                .missionList(missionPreviewDTOList)
                .build();
    }

    public static StoreResponseDTO.MissionPreviewDTO missionPreviewDTO(Mission mission) {
        return StoreResponseDTO.MissionPreviewDTO.builder()
                .missionName(mission.getMissionName())
                .build();
    }
}
