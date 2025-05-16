package com.example.umc2025.service.StoreService;

import com.example.umc2025.domain.Mission;
import com.example.umc2025.domain.Rating;
import com.example.umc2025.domain.Store;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);

    Page<Rating> getRatingList(Long id, Integer page);

    Page<Mission> getMissionList(Long storeId, Integer page);

}
