package com.benggri.communitybackend.model.entity.menu;

import java.time.LocalDateTime;

import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;

import com.benggri.communitybackend.model.entity.ParentEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "MENU_IDX", // 식별자 생성 이름
        sequenceName = "MENU_IDX", // DB 시퀀스 이름
        initialValue = 1, // 초기값
        allocationSize = 1 // 증가값
)
@Entity
@Table(name = "MENU")
public class MenuEntity extends ParentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MENU_IDX")
    @Comment("물리 PK")
    private Long idx;

    @Column(unique = true)
    @Comment("메뉴_ID(논리 PK)")
    private String menuId;

    @Comment("메뉴_명")
    private String menuName;

    @Comment("메뉴_설명")
    private String menuDesc;

    @Comment("상위_메뉴_ID")
    private String parentMenuId;

    @Comment("메뉴_순서")
    private Integer menuSortBy;

    @Comment("메뉴_접근권한")
    private String menuAuth;

    @Column(unique = true)
    @Comment("메뉴 URL")
    private String menuUrl;

}
