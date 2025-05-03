package com.example.umc88.domain.mapping;

import com.example.umc88.domain.Member;
import com.example.umc88.domain.Terms;
import com.example.umc88.domain.common.BaseEntity;
import lombok.*;


import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberAgree extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Terms terms;
}
