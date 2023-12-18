package com.benggri.communitybackend.model.entity.board.post;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoardPostEntity is a Querydsl query type for BoardPostEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardPostEntity extends EntityPathBase<BoardPostEntity> {

    private static final long serialVersionUID = -1462740769L;

    public static final QBoardPostEntity boardPostEntity = new QBoardPostEntity("boardPostEntity");

    public final com.benggri.communitybackend.model.entity.QParentEntity _super = new com.benggri.communitybackend.model.entity.QParentEntity(this);

    public final NumberPath<Long> boardIdx = createNumber("boardIdx", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> cmRegDtm = _super.cmRegDtm;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> cmUpdDtm = _super.cmUpdDtm;

    public final StringPath contents = createString("contents");

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final NumberPath<Long> memberIdx = createNumber("memberIdx", Long.class);

    public final DateTimePath<java.time.LocalDateTime> regDate = createDateTime("regDate", java.time.LocalDateTime.class);

    public final StringPath title = createString("title");

    public QBoardPostEntity(String variable) {
        super(BoardPostEntity.class, forVariable(variable));
    }

    public QBoardPostEntity(Path<? extends BoardPostEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoardPostEntity(PathMetadata metadata) {
        super(BoardPostEntity.class, metadata);
    }

}

