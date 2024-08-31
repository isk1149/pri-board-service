package com.joongnior.pri.board.dto.common;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BaseDto extends BaseTimeDto {
    protected String inserter;
    protected String updater;
}
