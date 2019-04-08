package com.board.controller;

import com.board.dto.BoardCreationDTO;
import com.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping("/{username}/boards/create")
    public void createBoard(@PathVariable("username") String username) {
        BoardCreationDTO boardCreationDTO = new BoardCreationDTO();
        boardCreationDTO.setName("Name");
        boardCreationDTO.setBackground("background");
        boardService.createNewBoard(username, boardCreationDTO);
    }
}
