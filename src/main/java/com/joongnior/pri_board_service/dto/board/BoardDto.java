package com.joongnior.pri_board_service.dto.board;

import com.joongnior.pri_board_service.domain.BoardEntity;
import com.joongnior.pri_board_service.dto.common.BaseDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter @Setter
@ToString
public class BoardDto extends BaseDto {
    private UUID id;
    private String name;
    private String description;

    public BoardDto(final BoardEntity boardEntity) {
        this.id = boardEntity.getId();
        this.name = boardEntity.getName();
        this.description = boardEntity.getDescription();
        this.inserter = boardEntity.getInserter();
        this.insertedDateTime = boardEntity.getInsertedDateTime();
        this.updater = boardEntity.getUpdater();
        this.updatedDateTime = boardEntity.getUpdatedDateTime();
    }
}
