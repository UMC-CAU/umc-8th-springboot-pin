package com.example.umc2025.service;

import com.example.umc2025.apiPayload.Code.status.ErrorStatus;
import com.example.umc2025.apiPayload.exception.handler.MissionHandler;
import com.example.umc2025.apiPayload.exception.handler.StoreHandler;
import com.example.umc2025.domain.Mission;
import com.example.umc2025.domain.Store;
import com.example.umc2025.repository.missionRepository.MissionRepository;
import com.example.umc2025.service.MemberService.MemberCommandService;
import com.example.umc2025.service.StoreService.StoreQueryService;
import com.example.umc2025.web.converter.MissionConverter;
import com.example.umc2025.web.dto.MissionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MissionService {

    private final StoreQueryService storeQueryService;
    private final MissionRepository missionRepository;

    @Transactional
    public Mission addMission(MissionDTO.AddDTO dto) {
        Mission newMission = MissionConverter.toMission(dto);

        Store store = storeQueryService.findStore(dto.getStoreId());

        if (missionRepository.existsByStoreIdAndMissionName(dto.getStoreId(), dto.getMissionName())) {
            throw new MissionHandler(ErrorStatus.DUPLICATE_MISSION);
        }


        newMission.setStore(store);
        missionRepository.save(newMission);

        return newMission;
    }

    public Mission findById(Long id) {
        return missionRepository.findById(id).orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
    }
}
