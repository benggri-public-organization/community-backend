package com.benggri.communitybackend.model.entity.board;

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
@SequenceGenerator(name = "BOARD_IDX", // 식별자 생성 이름
        sequenceName = "BOARD_IDX", // DB 시퀀스 이름
        initialValue = 1, // 초기값
        allocationSize = 1 // 증가값
)
@Entity
@Table(name = "BOARD")
public class BoardEntity extends ParentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_IDX")
    @Comment("물리 PK")
    private Long idx;

    @Comment("게시판_명")
    private String boardName;

    @Comment("게시판_설명")
    private String boardDesc;
}
