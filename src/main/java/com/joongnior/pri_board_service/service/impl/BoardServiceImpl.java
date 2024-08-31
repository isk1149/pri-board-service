package com.joongnior.pri_board_service.service.impl;

import com.joongnior.pri_board_service.domain.BoardEntity;
import com.joongnior.pri_board_service.dto.board.BoardDto;
import com.joongnior.pri_board_service.infra.BoardRepository;
import com.joongnior.pri_board_service.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public List<BoardDto> getBoards() {
        log.info("BoardServiceImpl getBoards start");
        List<BoardDto> boardDtos = new ArrayList<>();

        List<BoardEntity> boardEntities = boardRepository.getBoards();
        boardEntities.forEach(entity -> boardDtos.add(new BoardDto(entity)));
        return boardDtos;
    }
}
