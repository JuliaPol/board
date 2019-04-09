package com.board.controller;

import com.board.dto.NewColumnDTO;
import com.board.service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ColumnController {
    private ColumnService columnService;

    @Autowired
    public ColumnController(ColumnService columnService) {
        this.columnService = columnService;
    }

    @RequestMapping(value = "/{username}/newColumn", method = RequestMethod.POST)
    public void addNewColumnToBoard(@PathVariable("username") String username,
                                    @RequestBody NewColumnDTO newColumnDTO) {
        columnService.addNewColumnToBoard(username, newColumnDTO);
    }
}
