package com.joongnior.pri.board.service;

import com.joongnior.pri.board.dto.board.BoardDto;

import java.util.List;

public interface BoardService {
    List<BoardDto> getBoards();
}
