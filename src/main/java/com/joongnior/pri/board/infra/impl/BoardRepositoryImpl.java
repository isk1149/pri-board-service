package com.joongnior.pri.board.infra.impl;

import com.joongnior.pri.board.domain.board.BoardEntity;
import com.joongnior.pri.board.infra.BoardReposirotyQueryDsl;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static com.joongnior.pri.board.domain.board.QBoardEntity.boardEntity;

@Slf4j
public class BoardRepositoryImpl implements BoardReposirotyQueryDsl {
    private final JPAQueryFactory jpaQueryFactory;

    public BoardRepositoryImpl(EntityManager entityManager) {
        jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public List<BoardEntity> getBoards() {
        log.info("BoardRepositoryImpl getBoards start");
        return jpaQueryFactory
                .select(boardEntity)
                .from(boardEntity)
                .orderBy(boardEntity.insertedDateTime.asc())
                .fetch();
    }
}
