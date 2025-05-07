package com.example.umc2025.repository.missionRepository;


import com.example.umc2025.domain.Member;
import com.example.umc2025.domain.Mission;
import com.example.umc2025.domain.mapping.MemberMission;

import java.util.List;

public interface MissionRepositoryCustom {

    //내가 진행 완료한 미션 모아서 보는 쿼리(페이징 포함)
    List<Mission> findMissionByMemberAndCompletePaging(Member member, Long cursor);

    //내가 진행중인 미션 모아서 보는 쿼리(페이징 포함)
    List<Mission> findMissionByMemberAndTryingPaging(Member member, Long cursor);

    //내가 진행 완료한 미션 모아서 보는 쿼리
    List<Mission> findMissionByMemberAndComplete(Member member);

    //내가 진행중인 미션 모아서 보는 쿼리
    List<Mission> findMissionByMemberAndTrying(Member member);

    //홈화면 - 도전 가능한 미션 목록
    List<Mission> findMissionByLocationAndPossible(Member member, String location, Long cursor);

    //홈화면 쿼리
    List<MemberMission> findMissionByMemberAndLocation(Member member, String location);
}
