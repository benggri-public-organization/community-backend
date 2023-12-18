package com.benggri.communitybackend.model.entity.member;

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
@SequenceGenerator(name = "MEMBER_IDX", // 식별자 생성 이름
        sequenceName = "MEMBER_IDX", // DB 시퀀스 이름
        initialValue = 1, // 초기값
        allocationSize = 1 // 증가값
)
@Entity
@Table(name = "MEMBER")
public class MemberEntity extends ParentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_IDX")
    @Comment("물리 PK")
    private Long idx;

    @Column(unique = true)
    @Comment("이메일")
    private String email;
    @Comment("닉네임")
    private String nickname;
    @Comment("비밀번호")
    private String password;
    @Comment("멤버 타입")
    private String memberType;

    @Column(nullable = false)
    @CreationTimestamp
    @Convert(converter = LocalDateTimeConverter.class)
    @Comment("가입 일")
    private LocalDateTime joinDate;

    @Column(updatable = false, nullable = false)
    @CreationTimestamp
    @Convert(converter = LocalDateTimeConverter.class)
    @Comment("요청 일")
    private LocalDateTime reqDate;
}
