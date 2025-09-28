package fr.insee.tulipe.controller;

import fr.insee.tulipe.model.Sprint;
import fr.insee.tulipe.model.Task;
import fr.insee.tulipe.model.UserStory;
import fr.insee.tulipe.service.TaskService;
import fr.insee.tulipe.service.UserStoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/{id}/move")
    @ResponseBody
    public void moveTask(@PathVariable Integer id, @RequestParam String newStatus) {
        taskService.moveTask(id, newStatus);
    }

    @GetMapping("/")
    public String viewTasks(Model model) {
        List<Task> tasks = taskService.findAll();
        model.addAttribute("tasks", tasks);
        return "task/index";
    }

    @GetMapping("/{id}")
    public String viewSprint(@PathVariable Integer id, Model model) {
        Task task = taskService.findById(id);
        model.addAttribute("task", task);
        return "task/view";
    }


}
