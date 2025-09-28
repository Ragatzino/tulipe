package fr.insee.tulipe.service;

import fr.insee.tulipe.exceptions.UserStoryNotFoundException;
import fr.insee.tulipe.model.Sprint;
import fr.insee.tulipe.model.Task;
import fr.insee.tulipe.model.UserStory;
import fr.insee.tulipe.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStoryService {
    UserStoryRepository userStoryRepository;
    TaskService taskService;

    @Autowired
    public UserStoryService(UserStoryRepository userStoryRepository) {
        this.userStoryRepository = userStoryRepository;
    }

    public void save(UserStory userStory) {
        userStoryRepository.save(userStory);
    }

    public List<UserStory> findAllExcludingSprint(Sprint sprint) {
        List<UserStory> userStories = userStoryRepository.findAll();
        return userStories.stream().filter(userStory -> !sprint.equals(userStory.getSprint())).toList();
    }

    public List<UserStory> findAll() {
        return userStoryRepository.findAll();
    }

    public UserStory findById(Integer id) {
        return userStoryRepository.findById(id).orElseThrow(() -> new UserStoryNotFoundException("aucune user story en db"));
    }

    public void addTaskToUserStory(Integer id, Integer taskId) {
        UserStory userStory = findById(id);
        Task task = taskService.findById(taskId);
        userStory.getTasks().add(task);
        userStoryRepository.save(userStory);
    }

}
