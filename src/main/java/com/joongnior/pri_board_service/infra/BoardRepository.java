package com.joongnior.pri_board_service.infra;

import com.joongnior.pri_board_service.domain.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BoardRepository extends JpaRepository<BoardEntity, UUID>, BoardReposirotyQueryDsl {
}
