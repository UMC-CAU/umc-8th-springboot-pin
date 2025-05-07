package com.example.umc2025.repository.foodCategoryRepository;


import com.example.umc2025.domain.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long>, FoodCategoryRepositoryCustom {
}
