package com.benggri.communitybackend.model.entity.board;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoardEntity is a Querydsl query type for BoardEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardEntity extends EntityPathBase<BoardEntity> {

    private static final long serialVersionUID = -1309420635L;

    public static final QBoardEntity boardEntity = new QBoardEntity("boardEntity");

    public final com.benggri.communitybackend.model.entity.QParentEntity _super = new com.benggri.communitybackend.model.entity.QParentEntity(this);

    public final StringPath boardDesc = createString("boardDesc");

    public final StringPath boardName = createString("boardName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> cmRegDtm = _super.cmRegDtm;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> cmUpdDtm = _super.cmUpdDtm;

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public QBoardEntity(String variable) {
        super(BoardEntity.class, forVariable(variable));
    }

    public QBoardEntity(Path<? extends BoardEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoardEntity(PathMetadata metadata) {
        super(BoardEntity.class, metadata);
    }

}

