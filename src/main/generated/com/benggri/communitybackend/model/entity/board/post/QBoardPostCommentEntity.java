package com.benggri.communitybackend.model.entity.board.post;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoardPostCommentEntity is a Querydsl query type for BoardPostCommentEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardPostCommentEntity extends EntityPathBase<BoardPostCommentEntity> {

    private static final long serialVersionUID = -386305370L;

    public static final QBoardPostCommentEntity boardPostCommentEntity = new QBoardPostCommentEntity("boardPostCommentEntity");

    public final com.benggri.communitybackend.model.entity.QParentEntity _super = new com.benggri.communitybackend.model.entity.QParentEntity(this);

    public final NumberPath<Long> boardPostIdx = createNumber("boardPostIdx", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> cmRegDtm = _super.cmRegDtm;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> cmUpdDtm = _super.cmUpdDtm;

    public final StringPath contents = createString("contents");

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final NumberPath<Long> memberIdx = createNumber("memberIdx", Long.class);

    public final DateTimePath<java.time.LocalDateTime> regDate = createDateTime("regDate", java.time.LocalDateTime.class);

    public QBoardPostCommentEntity(String variable) {
        super(BoardPostCommentEntity.class, forVariable(variable));
    }

    public QBoardPostCommentEntity(Path<? extends BoardPostCommentEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoardPostCommentEntity(PathMetadata metadata) {
        super(BoardPostCommentEntity.class, metadata);
    }

}

