package com.example.umc2025.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/memberMission")
@RequiredArgsConstructor
public class MemberMissionController {

    private final MemberMissionService memberMissionService;
}
