package com.example.umc88.repository;

import com.example.umc88.domain.Member;
import com.example.umc88.domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.beans.JavaBean;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Modifying
    @Query("DELETE FROM Rating r WHERE r.member = :member")
    void deleteByMember(@Param("member") Member member);
}
