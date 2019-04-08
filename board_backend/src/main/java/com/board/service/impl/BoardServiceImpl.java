package com.board.service.impl;

import com.board.dto.BoardCreationDTO;
import com.board.dto.NewColumnDTO;
import com.board.model.Board;
import com.board.model.ColumnInBoard;
import com.board.model.ColumnStatus;
import com.board.model.User;
import com.board.repository.BoardRepository;
import com.board.repository.UserRepository;
import com.board.service.BoardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService {

    private BoardRepository boardRepository;
    private UserRepository userRepository;

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

    public void createNewBoard(String username, BoardCreationDTO boardDTO) {
        User user = userRepository.findByLogin(username);
        Board board = modelMapper.map(boardDTO, Board.class);
        board.setUsers(Collections.singletonList(user));
        boardRepository.save(board);
    }

    public void addNewColumn(String username, String board, NewColumnDTO newColumnDTO) {
        User user = userRepository.findByLogin(username);
        List<Board> boards = user.getBoards().stream()
                .filter(board1 -> board1.getName().equals(board)).collect(Collectors.toList());
        if (boards.size() > 0) {
            Board foundBoard = boards.get(0);
            ColumnInBoard columnInBoard = convertColumnToEntity(newColumnDTO);
            foundBoard.getColumnInBoards().add(columnInBoard);
            columnInBoard.setBoard(foundBoard);
            boardRepository.save(foundBoard);
        }
    }

    private ColumnInBoard convertColumnToEntity(NewColumnDTO newColumnDTO) {
        ColumnInBoard columnInBoard = modelMapper.map(newColumnDTO, ColumnInBoard.class);
        ColumnStatus columnStatus = new ColumnStatus();
        columnStatus.setName(newColumnDTO.getStatus());
        columnInBoard.setColumnStatus(columnStatus);
        return columnInBoard;
    }
}
