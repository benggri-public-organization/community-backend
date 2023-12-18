package com.benggri.communitybackend.model.entity.menu;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMenuEntity is a Querydsl query type for MenuEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMenuEntity extends EntityPathBase<MenuEntity> {

    private static final long serialVersionUID = 1574454165L;

    public static final QMenuEntity menuEntity = new QMenuEntity("menuEntity");

    public final com.benggri.communitybackend.model.entity.QParentEntity _super = new com.benggri.communitybackend.model.entity.QParentEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> cmRegDtm = _super.cmRegDtm;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> cmUpdDtm = _super.cmUpdDtm;

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final StringPath menuAuth = createString("menuAuth");

    public final StringPath menuDesc = createString("menuDesc");

    public final StringPath menuId = createString("menuId");

    public final StringPath menuName = createString("menuName");

    public final NumberPath<Integer> menuSortBy = createNumber("menuSortBy", Integer.class);

    public final StringPath menuUrl = createString("menuUrl");

    public final StringPath parentMenuId = createString("parentMenuId");

    public QMenuEntity(String variable) {
        super(MenuEntity.class, forVariable(variable));
    }

    public QMenuEntity(Path<? extends MenuEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMenuEntity(PathMetadata metadata) {
        super(MenuEntity.class, metadata);
    }

}

