package com.joongnior.pri.board.infra;

import com.joongnior.pri.board.domain.board.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BoardRepository extends JpaRepository<BoardEntity, UUID>, BoardReposirotyQueryDsl {
}
