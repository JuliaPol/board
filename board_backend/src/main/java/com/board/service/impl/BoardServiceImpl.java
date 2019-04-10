package com.board.service.impl;

import com.board.dto.BoardCreationDTO;
import com.board.model.Board;
import com.board.model.User;
import com.board.repository.BoardRepository;
import com.board.repository.UserRepository;
import com.board.service.BoardService;
import com.board.service.LinkGenerationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class BoardServiceImpl implements BoardService {

    private BoardRepository boardRepository;
    private UserRepository userRepository;
    private LinkGenerationService linkGenerationService;
    private ModelMapper modelMapper;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setLinkGenerationService(LinkGenerationService linkGenerationService) {
        this.linkGenerationService = linkGenerationService;
    }

    public void createNewBoard(BoardCreationDTO boardDTO) {
        User user = userRepository.findByLogin(boardDTO.getUsername());
        Board board = modelMapper.map(boardDTO, Board.class);
        board.setUsers(Collections.singletonList(user));
        board.setBoardLink(linkGenerationService.getLinkForNewBoard(boardDTO.getUsername(), board.getName()));
        boardRepository.save(board);
    }

}
