package com.joongnior.pri.board.service.impl;

import com.joongnior.pri.board.infra.BoardRepository;
import com.joongnior.pri.board.service.BoardService;
import com.joongnior.pri.board.domain.board.BoardEntity;
import com.joongnior.pri.board.dto.board.BoardDto;
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
        log.info("BoardServiceImpl.getBoards start");
        List<BoardDto> boardDtos = new ArrayList<>();

        List<BoardEntity> boardEntities = boardRepository.getBoards();
        boardEntities.forEach(entity -> boardDtos.add(new BoardDto(entity)));
        return boardDtos;
    }
}
