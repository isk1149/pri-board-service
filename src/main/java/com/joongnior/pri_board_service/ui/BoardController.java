package com.joongnior.pri_board_service.ui;

import com.joongnior.pri_board_service.dto.board.BoardDto;
import com.joongnior.pri_board_service.dto.common.ResponseDto;
import com.joongnior.pri_board_service.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
@Slf4j
public class BoardController {
    private final Environment env;
    private final BoardService boardService;

    @GetMapping("/healthcheck")
    public String healthcheck(@RequestHeader(value = "Accept", defaultValue = "") String acceptHeader) {
        String lineSeparator = "\n";

        if (acceptHeader.contains(MediaType.TEXT_HTML_VALUE))
            lineSeparator = "<br>";

        return "[" + env.getProperty("spring.application.name") + " healthcheck]" + lineSeparator
                + "port(local.server.port)=" + env.getProperty("local.server.port") + lineSeparator
                + "port(server.port)=" + env.getProperty("server.port") + lineSeparator
                + "with token secret=" + env.getProperty("token.secret") + lineSeparator
                + "with token time=" + env.getProperty("token.expiration_time") + lineSeparator
                + "with encryption-test=" + env.getProperty("encryption-test");
    }

    @GetMapping("/boards")
    public ResponseEntity<ResponseDto<List<BoardDto>>> getBoards() {
        log.info("BoardController getBoards start");
        List<BoardDto> boardDtos = boardService.getBoards();
        /*
        Lombok이 빌더 패턴을 생성할 때, 제네릭 타입을 올바르게 추론하지 못하고 기본적으로 Object 타입을 사용한다.
        이로 인해 ResponseDto<List<BoardDto>>를 기대하는 곳에서 ResponseDto<Object>를 반환하게 되며, 타입 불일치 오류가 발생한다.
        빌더를 호출할 때, 명시적으로 제네릭 타입을 지정하여 Lombok이 올바른 타입을 사용할 수 있도록 한다.
        ResponseDto.builder().data(boardDtos).build();
        =>
        ResponseDto.<List<BoardDto>>builder().data(boardDtos).build();
         */
        ResponseDto<List<BoardDto>> response = ResponseDto.<List<BoardDto>>builder()
                                                .data(boardDtos)
                                                .build();
        return ResponseEntity.ok().body(response);
    }

}
