package com.board.service.impl;

import com.board.dto.NewColumnDTO;
import com.board.model.Board;
import com.board.model.ColumnInBoard;
import com.board.model.ColumnStatus;
import com.board.repository.BoardRepository;
import com.board.repository.ColumnRepository;
import com.board.service.ColumnService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColumnServiceImpl implements ColumnService {

    private ModelMapper modelMapper;
    private ColumnRepository columnRepository;
    private BoardRepository boardRepository;

    @Autowired
    public ColumnServiceImpl(ColumnRepository columnRepository) {
        this.columnRepository = columnRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setBoardRepository(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public void addNewColumnToBoard(String username, NewColumnDTO newColumnDTO) {
        Board board = boardRepository.findBoardByNameAndUsersLogin(newColumnDTO.getBoardName(), username);
        if (board != null) {
            ColumnInBoard columnInBoard = convertColumnToEntity(newColumnDTO);
            board.getColumnInBoards().add(columnInBoard);
            columnInBoard.setBoard(board);
            columnRepository.save(columnInBoard);
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
