package com.example.umc2025.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -1506569263L;

    public static final QMember member = new QMember("member1");

    public final com.example.umc2025.domain.common.QBaseEntity _super = new com.example.umc2025.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final ListPath<Alarm, QAlarm> alarmList = this.<Alarm, QAlarm>createList("alarmList", Alarm.class, QAlarm.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<com.example.umc2025.domain.enums.Gender> gender = createEnum("gender", com.example.umc2025.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final ListPath<com.example.umc2025.domain.mapping.MemberAgree, com.example.umc2025.domain.mapping.QMemberAgree> memberAgreeList = this.<com.example.umc2025.domain.mapping.MemberAgree, com.example.umc2025.domain.mapping.QMemberAgree>createList("memberAgreeList", com.example.umc2025.domain.mapping.MemberAgree.class, com.example.umc2025.domain.mapping.QMemberAgree.class, PathInits.DIRECT2);

    public final ListPath<com.example.umc2025.domain.mapping.MemberMission, com.example.umc2025.domain.mapping.QMemberMission> memberMissionList = this.<com.example.umc2025.domain.mapping.MemberMission, com.example.umc2025.domain.mapping.QMemberMission>createList("memberMissionList", com.example.umc2025.domain.mapping.MemberMission.class, com.example.umc2025.domain.mapping.QMemberMission.class, PathInits.DIRECT2);

    public final ListPath<com.example.umc2025.domain.mapping.MemberPrefer, com.example.umc2025.domain.mapping.QMemberPrefer> memberPreferList = this.<com.example.umc2025.domain.mapping.MemberPrefer, com.example.umc2025.domain.mapping.QMemberPrefer>createList("memberPreferList", com.example.umc2025.domain.mapping.MemberPrefer.class, com.example.umc2025.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<Question, QQuestion> questionList = this.<Question, QQuestion>createList("questionList", Question.class, QQuestion.class, PathInits.DIRECT2);

    public final ListPath<Rating, QRating> ratingList = this.<Rating, QRating>createList("ratingList", Rating.class, QRating.class, PathInits.DIRECT2);

    public final EnumPath<com.example.umc2025.domain.enums.Role> role = createEnum("role", com.example.umc2025.domain.enums.Role.class);

    public final EnumPath<com.example.umc2025.domain.enums.SocialType> socialType = createEnum("socialType", com.example.umc2025.domain.enums.SocialType.class);

    public final StringPath specAddress = createString("specAddress");

    public final EnumPath<com.example.umc2025.domain.enums.MemberStatus> status = createEnum("status", com.example.umc2025.domain.enums.MemberStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

