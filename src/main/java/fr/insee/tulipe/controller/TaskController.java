package fr.insee.tulipe.controller;

import fr.insee.tulipe.model.Task;
import fr.insee.tulipe.model.UserStory;
import fr.insee.tulipe.service.TaskService;
import fr.insee.tulipe.service.UserStoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final UserStoryService userStoryService;
    public TaskController(TaskService taskService,UserStoryService userStoryService) {
        this.taskService = taskService;
        this.userStoryService = userStoryService;
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        Task task = new Task();

        model.addAttribute("task", task);
        List<UserStory> userstories = userStoryService.findAll();
        model.addAttribute("userStories", userstories);
        return "task/form"; // templates/task/form.html
    }

    @PostMapping
    public String createTask(@ModelAttribute Task task) {
        taskService.save(task);
        return "redirect:/";
    }
}
