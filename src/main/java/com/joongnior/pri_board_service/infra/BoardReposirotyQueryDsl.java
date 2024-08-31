package com.joongnior.pri_board_service.infra;

import com.joongnior.pri_board_service.domain.BoardEntity;

import java.util.List;

public interface BoardReposirotyQueryDsl {
    List<BoardEntity> getBoards();
}
