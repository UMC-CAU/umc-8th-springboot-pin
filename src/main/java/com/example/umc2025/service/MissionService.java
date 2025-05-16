package com.example.umc2025.service;

import com.example.umc2025.apiPayload.Code.status.ErrorStatus;
import com.example.umc2025.apiPayload.exception.handler.StoreHandler;
import com.example.umc2025.domain.Mission;
import com.example.umc2025.domain.Store;
import com.example.umc2025.repository.missionRepository.MissionRepository;
import com.example.umc2025.service.MemberService.MemberCommandService;
import com.example.umc2025.service.StoreService.StoreQueryService;
import com.example.umc2025.web.converter.MissionConverter;
import com.example.umc2025.web.dto.MissionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MissionService {

    private final StoreQueryService storeQueryService;

    @Transactional
    public Mission addMission(MissionDTO.AddDTO dto) {
        Mission newMission = MissionConverter.toMission(dto);

        Optional<Store> store = storeQueryService.findStore(dto.getStoreId());

        Store storeValue = store.orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        newMission.setStore(storeValue);

        return newMission;
    }
}
