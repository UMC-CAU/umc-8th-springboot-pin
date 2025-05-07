package com.example.umc2025.repository.memberRepository;

import com.example.umc2025.domain.Member;
import com.example.umc2025.domain.QMember;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member = QMember.member;

    @Override
    public Member findMemberById(Long id) {

        BooleanBuilder predicate = new BooleanBuilder();

        predicate.and(member.id.eq(id));

        return jpaQueryFactory
                .selectFrom(member)
                .where(predicate)
                .fetchOne();
    }
}
