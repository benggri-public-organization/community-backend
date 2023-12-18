package com.benggri.communitybackend.controller.board;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benggri.communitybackend.service.board.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public ResponseEntity findList() {
        return ResponseEntity.ok().body(boardService.findList());
    }
}
