package com.board.repository;

import com.board.model.ColumnInBoard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColumnRepository extends CrudRepository<ColumnInBoard, Long> {
}
