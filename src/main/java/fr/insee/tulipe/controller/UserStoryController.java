package fr.insee.tulipe.controller;

import fr.insee.tulipe.model.UserStory;
import fr.insee.tulipe.service.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @PostMapping
    public String createUserStory(@ModelAttribute UserStory userStory) {
        userStoryService.save(userStory);
        return "redirect:/";
    }

}
