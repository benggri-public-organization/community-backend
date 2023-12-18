package com.benggri.communitybackend.model.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class ParentEntity {
    @JsonIgnore
    @Column(updatable = false, nullable = false)
    @CreationTimestamp
    @Convert(converter = LocalDateTimeConverter.class)
    @Comment("공통 생성일")
    private LocalDateTime cmRegDtm;

    @JsonIgnore
    @LastModifiedDate
    @Column(nullable = false)
    @CreationTimestamp
    @Convert(converter = LocalDateTimeConverter.class)
    @Comment("공통 수정일")
    private LocalDateTime cmUpdDtm;
}
