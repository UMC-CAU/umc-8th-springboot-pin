package com.example.umc2025.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStoreFoodCategory is a Querydsl query type for StoreFoodCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStoreFoodCategory extends EntityPathBase<StoreFoodCategory> {

    private static final long serialVersionUID = -585707162L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStoreFoodCategory storeFoodCategory = new QStoreFoodCategory("storeFoodCategory");

    public final StringPath foodCateforyName = createString("foodCateforyName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QStore storeId;

    public QStoreFoodCategory(String variable) {
        this(StoreFoodCategory.class, forVariable(variable), INITS);
    }

    public QStoreFoodCategory(Path<? extends StoreFoodCategory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStoreFoodCategory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStoreFoodCategory(PathMetadata metadata, PathInits inits) {
        this(StoreFoodCategory.class, metadata, inits);
    }

    public QStoreFoodCategory(Class<? extends StoreFoodCategory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.storeId = inits.isInitialized("storeId") ? new QStore(forProperty("storeId")) : null;
    }

}

