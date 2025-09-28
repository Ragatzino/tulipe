package fr.insee.tulipe.service;

import fr.insee.tulipe.exceptions.TaskNotFoundException;
import fr.insee.tulipe.model.Sprint;
import fr.insee.tulipe.model.Task;
import fr.insee.tulipe.model.TaskStatus;
import fr.insee.tulipe.model.UserStory;
import fr.insee.tulipe.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository TaskRepository) {
        this.taskRepository = TaskRepository;
    }

    public void save(Task Task) {
        taskRepository.save(Task);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(Integer id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElseThrow(() -> new TaskNotFoundException("Tâche introuvable"));
    }

    public void moveTask(Integer id, String newStatus) {
        Task task = findById(id);
        task.setStatus(TaskStatus.valueOf(newStatus));
        this.save(task);
    }
}
