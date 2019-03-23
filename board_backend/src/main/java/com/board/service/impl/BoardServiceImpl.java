package com.board.service.impl;

import com.board.dto.BoardCreationDTO;
import com.board.model.Board;
import com.board.model.User;
import com.board.repository.BoardRepository;
import com.board.service.BoardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository, ModelMapper modelMapper) {
        this.boardRepository = boardRepository;
        this.modelMapper = modelMapper;
    }

    public void createNewBoard(BoardCreationDTO boardDTO) {
        boardRepository.save(convertToEntity(boardDTO));
    }

    private Board convertToEntity(BoardCreationDTO boardCreationDTO) {
        Board board = modelMapper.map(boardCreationDTO, Board.class);
        User user = modelMapper.map(boardCreationDTO.getWhoCreate(), User.class);
        board.setUsers(Collections.singletonList(user));
        return board;
    }
}
