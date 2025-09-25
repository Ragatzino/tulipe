package fr.insee.tulipe.controller;

import fr.insee.tulipe.model.Sprint;
import fr.insee.tulipe.model.Task;
import fr.insee.tulipe.model.UserStory;
import fr.insee.tulipe.service.SprintService;
import fr.insee.tulipe.service.TaskService;
import fr.insee.tulipe.service.UserStoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private final SprintService sprintService;
    private final UserStoryService userStoryService;
    private final TaskService taskService;

    public HomeController(SprintService sprintService, UserStoryService userStoryService, TaskService taskService) {
        this.sprintService = sprintService;
        this.userStoryService = userStoryService;
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Sprint> sprints = sprintService.findAll(); // récupère tous les sprints
        List<UserStory> userStories = userStoryService.findAll();
        List<Task> tasks = taskService.findAll();
        model.addAttribute("sprints", sprints);
        model.addAttribute("userStories", userStories);
        model.addAttribute("tasks", tasks);
        return "home"; // template home.html
    }
}