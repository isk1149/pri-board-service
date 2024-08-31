package com.joongnior.pri_board_service.dto.common;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class BaseTimeDto {
    protected LocalDateTime insertedDateTime;
    protected LocalDateTime updatedDateTime;
}
