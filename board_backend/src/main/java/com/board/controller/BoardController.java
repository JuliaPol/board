package com.board.controller;

import com.board.dto.BoardCreationDTO;
import com.board.dto.NewColumnDTO;
import com.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardController {

    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping(value = "/{username}/boards/create", method = RequestMethod.POST)
    public void createBoard(@PathVariable("username") String username,
                            @RequestBody BoardCreationDTO boardCreationDTO) {
        boardService.createNewBoard(username, boardCreationDTO);
    }
}
