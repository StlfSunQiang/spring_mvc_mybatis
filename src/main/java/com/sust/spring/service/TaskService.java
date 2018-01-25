package com.sust.spring.service;

import com.sust.spring.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskMapper taskMapper;

    public int findAllTasksCount(){
        return taskMapper.findAllTasksCount();
    }

    public int findAllOpenTasksCount(){
        return taskMapper.findAllOpenTasksCount();
    }

}
