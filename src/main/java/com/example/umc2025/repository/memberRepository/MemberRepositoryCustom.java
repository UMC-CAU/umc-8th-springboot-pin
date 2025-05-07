package com.example.umc2025.repository.memberRepository;


import com.example.umc2025.domain.Member;

public interface MemberRepositoryCustom {

    //맴버 조회
    Member findMemberById(Long id);

}
