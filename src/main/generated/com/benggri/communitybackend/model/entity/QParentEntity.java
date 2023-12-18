package com.benggri.communitybackend.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QParentEntity is a Querydsl query type for ParentEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QParentEntity extends EntityPathBase<ParentEntity> {

    private static final long serialVersionUID = 125837929L;

    public static final QParentEntity parentEntity = new QParentEntity("parentEntity");

    public final DateTimePath<java.time.LocalDateTime> cmRegDtm = createDateTime("cmRegDtm", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> cmUpdDtm = createDateTime("cmUpdDtm", java.time.LocalDateTime.class);

    public QParentEntity(String variable) {
        super(ParentEntity.class, forVariable(variable));
    }

    public QParentEntity(Path<? extends ParentEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QParentEntity(PathMetadata metadata) {
        super(ParentEntity.class, metadata);
    }

}

