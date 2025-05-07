package com.example.umc2025.repository.ratingRepository;


import com.example.umc2025.domain.Member;
import com.example.umc2025.domain.Rating;
import com.example.umc2025.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RatingRepository extends JpaRepository<Rating, Long>, RatingRepositoryCustom {

    Page<Rating> findAllByStore(Store store, PageRequest pageRequest);

    Page<Rating> findAllByMember(Member member, PageRequest pageRequest);

    @Modifying
    @Query("DELETE FROM Rating r WHERE r.member = :member")
    void deleteByMember(@Param("member") Member member);
}
