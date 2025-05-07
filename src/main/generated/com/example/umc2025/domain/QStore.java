package com.example.umc2025.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStore is a Querydsl query type for Store
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStore extends EntityPathBase<Store> {

    private static final long serialVersionUID = 1204317386L;

    public static final QStore store = new QStore("store");

    public final NumberPath<Float> avgRating = createNumber("avgRating", Float.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath location = createString("location");

    public final ListPath<Mission, QMission> missionList = this.<Mission, QMission>createList("missionList", Mission.class, QMission.class, PathInits.DIRECT2);

    public final EnumPath<com.example.umc2025.domain.enums.StoreOperationState> operationState = createEnum("operationState", com.example.umc2025.domain.enums.StoreOperationState.class);

    public final TimePath<java.time.LocalTime> operationTime = createTime("operationTime", java.time.LocalTime.class);

    public final ListPath<Question, QQuestion> questionList = this.<Question, QQuestion>createList("questionList", Question.class, QQuestion.class, PathInits.DIRECT2);

    public final ListPath<Rating, QRating> ratingList = this.<Rating, QRating>createList("ratingList", Rating.class, QRating.class, PathInits.DIRECT2);

    public final StringPath storeName = createString("storeName");

    public final StringPath storeType = createString("storeType");

    public QStore(String variable) {
        super(Store.class, forVariable(variable));
    }

    public QStore(Path<? extends Store> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStore(PathMetadata metadata) {
        super(Store.class, metadata);
    }

}

