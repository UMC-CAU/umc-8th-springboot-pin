package com.example.umc2025.service.StoreService;

import com.example.umc2025.domain.Mission;
import com.example.umc2025.domain.Rating;
import com.example.umc2025.domain.Store;
import com.example.umc2025.repository.StoreRepository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findStoresByNameAndScore(String name, Float score) {
        List<Store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);
        filteredStores.forEach(store -> System.out.println("Store: " + store));
        return filteredStores;
    }

    @Override
    public Page<Rating> getRatingList(Long id, Integer page) {
        return null;
    }

    @Override
    public Page<Mission> getMissionList(Long storeId, Integer page) {
        return null;
    }
}
