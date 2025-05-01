package com.example.umc88.repository;

import com.example.umc88.domain.Alarm;
import com.example.umc88.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlarmRepository extends JpaRepository<Alarm, Long> {

    @Modifying
    @Query("DELETE FROM Rating r WHERE r.member = :member")
    void deleteByMember(@Param("member") Member member);
}
