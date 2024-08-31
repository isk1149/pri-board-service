package com.joongnior.pri_board_service.service.impl;

import com.joongnior.pri_board_service.dto.board.BoardDto;
import com.joongnior.pri_board_service.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@Rollback(value = false)
class BoardServiceImplTest {

    @Autowired
    private BoardService boardService;

    @Test
    public void getBoards() {
        List<BoardDto> boardDtos = boardService.getBoards();
        if (boardDtos != null && boardDtos.size() != 0) {
            System.out.println("boardDtos.size = " + boardDtos.size());
            boardDtos.forEach(System.out::println);
        }

    }
}