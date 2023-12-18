package com.benggri.communitybackend.model.entity.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMemberEntity is a Querydsl query type for MemberEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberEntity extends EntityPathBase<MemberEntity> {

    private static final long serialVersionUID = 1914808693L;

    public static final QMemberEntity memberEntity = new QMemberEntity("memberEntity");

    public final com.benggri.communitybackend.model.entity.QParentEntity _super = new com.benggri.communitybackend.model.entity.QParentEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> cmRegDtm = _super.cmRegDtm;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> cmUpdDtm = _super.cmUpdDtm;

    public final StringPath email = createString("email");

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final DateTimePath<java.time.LocalDateTime> joinDate = createDateTime("joinDate", java.time.LocalDateTime.class);

    public final StringPath memberType = createString("memberType");

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final DateTimePath<java.time.LocalDateTime> reqDate = createDateTime("reqDate", java.time.LocalDateTime.class);

    public QMemberEntity(String variable) {
        super(MemberEntity.class, forVariable(variable));
    }

    public QMemberEntity(Path<? extends MemberEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberEntity(PathMetadata metadata) {
        super(MemberEntity.class, metadata);
    }

}

