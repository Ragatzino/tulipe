package fr.insee.tulipe.service;

import fr.insee.tulipe.exceptions.SprintNotFoundException;
import fr.insee.tulipe.model.Sprint;
import fr.insee.tulipe.repository.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintService {
    private SprintRepository sprintRepository;
    public SprintService(@Autowired SprintRepository sprintRepository) {
        this.sprintRepository = sprintRepository;
    }
    public List<Sprint> findAll() {
        return sprintRepository.findAll();
    }

    public Sprint save(Sprint sprint) {
        return sprintRepository.save(sprint);
    }

    public Sprint findById(Integer id) {
        return sprintRepository.findById(id).orElseThrow(() -> new SprintNotFoundException("No sprint found"));
    }

    public void addUserStoryToSprint(Integer id, Integer userStoryId) {
    }
}
