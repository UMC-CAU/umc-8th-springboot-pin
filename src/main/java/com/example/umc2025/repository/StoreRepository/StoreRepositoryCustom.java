package com.example.umc2025.repository.StoreRepository;

import com.example.umc2025.domain.Store;


import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
