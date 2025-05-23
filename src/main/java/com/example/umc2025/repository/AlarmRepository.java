package com.example.umc2025.repository;

import com.example.umc2025.domain.Alarm;
import com.example.umc2025.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlarmRepository extends JpaRepository<Alarm, Long> {

    @Modifying
    @Query("DELETE FROM Alarm a WHERE a.member = :member")
    void deleteByMember(@Param("member") Member member);
}
