package com.board.service;

import com.board.dto.BoardCreationDTO;

public interface BoardService {

    void createNewBoard(BoardCreationDTO boardDTO);
}
