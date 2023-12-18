package com.benggri.communitybackend.service.board;

import java.util.List;

import org.springframework.stereotype.Service;

import com.benggri.communitybackend.repository.board.BoardQuerydsl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardQuerydsl boardQuerydsl;

    public List findList() {
        return boardQuerydsl.findList();
    }
}
