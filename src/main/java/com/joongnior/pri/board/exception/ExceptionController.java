package com.joongnior.pri.board.exception;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@Slf4j
public class ExceptionController {
    /***** RuntimeException *****/
    //GlobalExceptionHandler - EntityNotFoundException 핸들러 테스트
    @GetMapping("/entity-not-found-exception")
    public void entityNotFoundException() {
        log.info("ExceptionController entityNotFoundException start");
        throw new EntityNotFoundException();
    }

    //GlobalExceptionHandler - DataAccessException 핸들러 테스트
    @GetMapping("/cannot-acquire-lock-exception")
    public void cannotAcquireLockException() {
        log.info("ExceptionController cannotAcquireLockException start");
        throw new CannotAcquireLockException("CannotAcquireLockException test");
    }

    //GlobalExceptionHandler - RuntimeException 핸들러 테스트
    @GetMapping("/runtime-exception")
    public void runtimeException() {
        log.info("ExceptionController runtimeException start");
        throw new RuntimeException();
    }
    /****************************/

    /***** IOException *****/
    //GlobalExceptionHandler - FileNotFoundException 핸들러 테스트
    @GetMapping("/file-not-found-exception")
    public void fileNotFoundException() throws FileNotFoundException {
        log.info("ExceptionController fileNotFoundException start");
        throw new FileNotFoundException();
    }

    //GlobalExceptionHandler - IOException 핸들러 테스트
    @GetMapping("/io-exception")
    public void ioException() throws IOException {
        log.info("ExceptionController ioException start");
        throw new IOException();
    }
    /***********************/

    //GlobalExceptionHandler - Exception 핸들러 테스트
    @GetMapping("/exception")
    public void exception() throws Exception {
        log.info("ExceptionController exception start");
        throw new Exception();
    }
}
