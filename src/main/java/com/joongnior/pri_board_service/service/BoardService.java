package com.joongnior.pri_board_service.service;

import com.joongnior.pri_board_service.dto.board.BoardDto;

import java.util.List;

public interface BoardService {
    List<BoardDto> getBoards();
}
