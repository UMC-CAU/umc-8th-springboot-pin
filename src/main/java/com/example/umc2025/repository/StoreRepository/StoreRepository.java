package com.example.umc2025.repository.StoreRepository;

import com.example.umc2025.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}
