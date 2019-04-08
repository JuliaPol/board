package com.board.service;

import com.board.dto.BoardCreationDTO;
import com.board.dto.NewColumnDTO;

public interface BoardService {

    void createNewBoard(String username, BoardCreationDTO boardDTO);

    void addNewColumn(String username, String board, NewColumnDTO newColumnDTO);
}
