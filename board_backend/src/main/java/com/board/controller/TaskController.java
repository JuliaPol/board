package com.board.controller;

import com.board.dto.NewColumnDTO;
import com.board.dto.NewTaskDTO;
import com.board.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value = "/tasks/newTask", method = RequestMethod.POST)
    public void addNewTaskToBoard(@RequestBody NewTaskDTO newTaskDTO)  {
        taskService.addNewTaskToColumn(newTaskDTO);
    }
}
