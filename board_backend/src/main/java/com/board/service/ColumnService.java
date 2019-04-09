package com.board.service;

import com.board.dto.NewColumnDTO;

public interface ColumnService {
    void addNewColumnToBoard(String username, NewColumnDTO newColumnDTO);
}
