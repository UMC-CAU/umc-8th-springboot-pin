package com.example.umc88.service;

import com.example.umc88.domain.Member;
import com.example.umc88.repository.AlarmRepository;
import com.example.umc88.repository.MemberRepository;
import com.example.umc88.repository.QuestionRepository;
import com.example.umc88.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final RatingRepository ratingRepository;
    private final QuestionRepository questionRepository;
    private final AlarmRepository alarmRepository;

    @Transactional
    public void removeMemberInfo(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 맴버 입니다."));

        member.removeMember();

        ratingRepository.deleteByMember(member);
        questionRepository.deleteByMember(member);
        alarmRepository.deleteByMember(member);
    }
}
