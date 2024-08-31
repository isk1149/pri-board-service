package com.joongnior.pri.board.dto.common;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class BaseTimeDto {
    protected LocalDateTime insertedDateTime;
    protected LocalDateTime updatedDateTime;
}
