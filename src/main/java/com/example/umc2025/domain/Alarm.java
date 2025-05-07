package com.example.umc2025.domain;


import com.example.umc2025.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Alarm extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    private boolean isConfirmed;

    @Column(length = 10)
    private String alarm_type;

    @Column(length = 200)
    private String title;

    @Column(length = 2000)
    private String content;
}
