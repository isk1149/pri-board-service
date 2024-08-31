package com.joongnior.pri.board.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@SuperBuilder
@Getter
@NoArgsConstructor
public class BaseEntity extends BaseTimeEntity {
    @Column(updatable = false)
    protected String inserter;
    protected String updater;

    public void setUpdater(String updater) {
        this.updater = updater;
    }
}
