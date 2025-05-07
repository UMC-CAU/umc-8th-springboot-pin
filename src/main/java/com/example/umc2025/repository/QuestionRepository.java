package com.example.umc2025.repository;


import com.example.umc2025.domain.Member;
import com.example.umc2025.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Modifying
    @Query("DELETE FROM Question q WHERE q.member = :member")
    void deleteByMember(@Param("member") Member member);
}
