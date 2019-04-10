package com.board.service.impl;

import com.board.dto.NewColumnDTO;
import com.board.model.Board;
import com.board.model.ColumnInBoard;
import com.board.model.ColumnStatus;
import com.board.repository.BoardRepository;
import com.board.repository.ColumnRepository;
import com.board.service.ColumnService;
import com.board.service.LinkGenerationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColumnServiceImpl implements ColumnService {

    private ModelMapper modelMapper;
    private ColumnRepository columnRepository;
    private BoardRepository boardRepository;
    private LinkGenerationService linkGenerationService;

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

    @Autowired
    public void setLinkGenerationService(LinkGenerationService linkGenerationService) {
        this.linkGenerationService = linkGenerationService;
    }

    @Override
    public void addNewColumnToBoard(NewColumnDTO newColumnDTO) {
        String board = newColumnDTO.getBoardLink();
        Board boardFound = boardRepository.findBoardByBoardLink(board);
        if (boardFound != null) {
            ColumnInBoard columnInBoard = convertColumnToEntity(newColumnDTO);
            columnInBoard.setColumnLink(linkGenerationService.getLinkForNewBoard(board, columnInBoard.getName()));
            boardFound.getColumnInBoards().add(columnInBoard);
            columnInBoard.setBoard(boardFound);
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
