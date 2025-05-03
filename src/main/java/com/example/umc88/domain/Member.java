package com.example.umc88.domain;

import com.example.umc88.domain.common.BaseEntity;

import com.example.umc88.domain.enums.Gender;
import com.example.umc88.domain.enums.MemberStatus;
import com.example.umc88.domain.enums.Role;
import com.example.umc88.domain.enums.SocialType;
import com.example.umc88.domain.mapping.MemberAgree;
import com.example.umc88.domain.mapping.MemberMission;
import com.example.umc88.domain.mapping.MemberPrefer;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 40)
    private String address;

    @Column(nullable = false, length = 40)
    private String specAddress;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    @ColumnDefault("ACTIVE")
    private MemberStatus status;

    private LocalDate inactiveDate;

    @Column(nullable = false, length = 50)
    private String email;

    @ColumnDefault("0")
    private Integer point;

    //스프링 시큐리티 관련 설정
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Rating> ratingList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Question> questionList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Alarm> alarmList = new ArrayList<>();

    public void removeMember() {
        this.status = MemberStatus.INACTIVE;
        this.inactiveDate = LocalDate.now();

        // 연관관계 끊기 → orphanRemoval = true 동작
        this.memberAgreeList.clear();
        this.memberPreferList.clear();
        this.memberMissionList.clear();

        // 나머지 orphanRemoval = false 관계는 직접 delete query로 제거
    }

}
