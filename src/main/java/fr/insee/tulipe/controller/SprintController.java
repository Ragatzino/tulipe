package fr.insee.tulipe.controller;

import fr.insee.tulipe.model.Sprint;
import fr.insee.tulipe.model.Task;
import fr.insee.tulipe.model.TaskStatus;
import fr.insee.tulipe.model.UserStory;
import fr.insee.tulipe.service.SprintService;
import fr.insee.tulipe.service.TaskService;
import fr.insee.tulipe.service.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller()
@RequestMapping("/sprints")
public class SprintController {
    private SprintService sprintService;
    private UserStoryService userStoryService;
    private TaskService taskService;
    @Autowired
    public void setUserStoryService(UserStoryService userStoryService) {
        this.userStoryService = userStoryService;
    }

    @Autowired
    public void setSprintService(SprintService sprintService) {
        this.sprintService = sprintService;
    }
    @GetMapping("/")
    public String viewSprints(Model model) {
        List<Sprint> sprints = sprintService.findAll();
        model.addAttribute("sprints", sprints);
        return "sprint/index";
    }

    @GetMapping("/{id}")
    public String viewSprint(@PathVariable Integer id, Model model) {
        Sprint sprint = sprintService.findById(id);

        List<UserStory> availableUserStories = userStoryService.findAllExcludingSprint(sprint);

        model.addAttribute("sprint", sprint);
        model.addAttribute("availableUserStories", availableUserStories);
        System.out.println(availableUserStories);
        return "sprint/view";
    }

    @PostMapping("/{id}/addUserStory")
    public String addUserStoryToSprint(@PathVariable Integer id, @RequestParam Integer userStoryId) {
        sprintService.addUserStoryToSprint(id, userStoryId);
        return "redirect:/sprints/" + id;
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        Sprint sprint = new Sprint();
        // tentative valeur par défaut
        sprint.setDateDebut(LocalDate.now());
        sprint.setDateFin(LocalDate.now().plusWeeks(3));
        model.addAttribute("sprint",sprint);
        return "sprint/form";
    }
    @PostMapping
    public String createSprint(@ModelAttribute Sprint sprint) {
        System.out.println(sprint);
        sprintService.save(sprint);
        return "redirect:/";
    }
    @PostMapping("/tasks/{id}/move")
    @ResponseBody
    public void moveTask(@PathVariable Integer id, @RequestParam String newStatus) {
        taskService.moveTask(id, newStatus);
    }

}
