package com.board.service.impl;

import com.board.dto.NewTaskDTO;
import com.board.model.ColumnInBoard;
import com.board.model.Task;
import com.board.repository.ColumnRepository;
import com.board.repository.TaskRepository;
import com.board.service.LinkGenerationService;
import com.board.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TaskServiceImpl implements TaskService {

    private ModelMapper modelMapper;
    private TaskRepository taskRepository;
    private ColumnRepository columnRepository;
    private LinkGenerationService linkGenerationService;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setColumnRepository(ColumnRepository columnRepository) {
        this.columnRepository = columnRepository;
    }

    @Autowired
    public void setLinkGenerationService(LinkGenerationService linkGenerationService) {
        this.linkGenerationService = linkGenerationService;
    }

    public void addNewTaskToColumn(NewTaskDTO newTaskDTO) {
        String columnLink = newTaskDTO.getColumnLink();
        ColumnInBoard columnInBoard = columnRepository.findByColumnLink(columnLink);
        if (columnInBoard != null) {
            Task task = modelMapper.map(newTaskDTO, Task.class);
            task.setDateOfCreation(new Date());
            task.setExpirationDate(newTaskDTO.getExpirationDate());
            task.setTaskLink(linkGenerationService.getLinkForNewBoard(columnLink, task.getName()));
            task.setColumnInBoard(columnInBoard);
            columnInBoard.getTasks().add(task);
            taskRepository.save(task);
        }
    }
}
