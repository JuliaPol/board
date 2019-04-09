package com.board.service.impl;

import com.board.dto.NewTaskDTO;
import com.board.repository.TaskRepository;
import com.board.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    private ModelMapper modelMapper;
    private TaskRepository taskRepository;


    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public void addNewTaskToColumn(NewTaskDTO newTaskDTO) {

    }
}
