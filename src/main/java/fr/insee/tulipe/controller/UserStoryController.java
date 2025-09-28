package fr.insee.tulipe.controller;

import fr.insee.tulipe.model.Task;
import fr.insee.tulipe.model.UserStory;
import fr.insee.tulipe.service.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/userstories")
public class UserStoryController {
    UserStoryService userStoryService;
    @Autowired
    public void setUserStoryService(UserStoryService userStoryService) {
        this.userStoryService = userStoryService;
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        UserStory us = new UserStory();
        model.addAttribute("userStory", us);
        return "userstory/form"; // templates/userstory/form.html
    }
    @GetMapping("/")
    public String listUserStories(Model model) {
        List<UserStory> userStories = userStoryService.findAll();
        model.addAttribute("userStories", userStories);
        return "userstory/index";
    }

    // ✅ Vue détaillée d'une User Story avec ses tâches
    @GetMapping("/{id}")
    public String viewUserStory(@PathVariable Integer id, Model model) {
        UserStory userStory = userStoryService.findById(id);

        model.addAttribute("userStory", userStory);
        return "userstory/view";
    }
    @PostMapping
    public String createUserStory(@ModelAttribute UserStory userStory) {
        userStoryService.save(userStory);
        return "redirect:/";
    }

}
