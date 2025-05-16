package com.example.umc2025.service.MemberMissionService;

import com.example.umc2025.apiPayload.Code.status.ErrorStatus;
import com.example.umc2025.apiPayload.exception.handler.MemberMissionHandler;
import com.example.umc2025.domain.Member;
import com.example.umc2025.domain.Mission;
import com.example.umc2025.domain.mapping.MemberMission;
import com.example.umc2025.repository.memberMissionRepository.MemberMissionRepository;
import com.example.umc2025.service.MemberService.MemberService;
import com.example.umc2025.service.MissionService;
import com.example.umc2025.web.dto.MemberMissionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberMissionServiceImpl implements MemberMissionService {

    private final MemberService memberService;
    private final MissionService missionService;
    private final MemberMissionRepository memberMissionRepository;


    @Override
    public MemberMission addMemberMission(MemberMissionRequestDTO.addRequestDTO requestDTO) {
        Member member = memberService.findById(requestDTO.getMemberId());
        Mission mission = missionService.findById(requestDTO.getMissionId());

        List<MemberMission> list = memberMissionRepository.findAllByMemberAndMission(member, mission);

        if (list.size() != 0) {
            throw new MemberMissionHandler(ErrorStatus.MEMBERMISSION_EXIST);
        }

        MemberMission memberMission = new MemberMission(member, mission);
        return memberMission;
    }
}
