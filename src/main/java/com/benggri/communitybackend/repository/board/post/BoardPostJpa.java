package com.benggri.communitybackend.repository.board.post;

import org.springframework.data.jpa.repository.JpaRepository;

import com.benggri.communitybackend.model.entity.board.post.BoardPostEntity;

public interface BoardPostJpa extends JpaRepository<BoardPostEntity, Long> {
}
