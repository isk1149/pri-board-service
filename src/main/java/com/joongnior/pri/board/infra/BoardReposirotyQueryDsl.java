package com.joongnior.pri.board.infra;

import com.joongnior.pri.board.domain.board.BoardEntity;

import java.util.List;

public interface BoardReposirotyQueryDsl {
    List<BoardEntity> getBoards();
}
