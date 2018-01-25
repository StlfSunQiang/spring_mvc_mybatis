package com.sust.spring.web.controller;

import com.sust.spring.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "Home",method = RequestMethod.GET)
public class HomeController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(path="/",method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("totalTasks",taskService.findAllTasksCount());
        model.addAttribute("totalOpenTasks",taskService.findAllOpenTasksCount());
        return "home";
    }
}
