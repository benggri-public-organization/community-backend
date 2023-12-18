package com.benggri.communitybackend.repository.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.benggri.communitybackend.model.entity.member.MemberEntity;

public interface MemberJpa extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findByEmail(String email);
}
