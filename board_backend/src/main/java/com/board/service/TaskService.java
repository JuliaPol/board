package com.board.service;


import com.board.dto.NewTaskDTO;

public interface TaskService {

    void addNewTaskToColumn(NewTaskDTO newTaskDTO);
}
