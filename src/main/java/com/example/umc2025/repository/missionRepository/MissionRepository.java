package com.example.umc2025.repository.missionRepository;


import com.example.umc2025.domain.Mission;
import com.example.umc2025.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {

    Page<Mission> findAllByStore(Store store, PageRequest request);


}
