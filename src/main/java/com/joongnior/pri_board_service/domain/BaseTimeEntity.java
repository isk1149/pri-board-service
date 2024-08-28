package com.joongnior.pri_board_service.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@MappedSuperclass
@SuperBuilder
@Getter
@NoArgsConstructor
public class BaseTimeEntity {
    @Column(updatable = false)
    protected LocalDateTime insertedDateTime;
    protected LocalDateTime updatedDateTime;

    @PrePersist
    protected void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        insertedDateTime = now;
        updatedDateTime = now;
    }

    public void setUpdatedDateTime() {
        this.updatedDateTime = LocalDateTime.now();
    }

    /*
    @PreUpdate
    protected void preUpdate() {
        this.updatedDateTime = LocalDateTime.now();
    }
     */
}
