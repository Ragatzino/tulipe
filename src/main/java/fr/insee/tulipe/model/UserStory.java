package fr.insee.tulipe.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Entity
public class UserStory extends ArtefactAgile{
    @OneToMany
    List<Task> tasks;
    @Enumerated(EnumType.STRING)
    Priority priority;

    @ManyToOne
    @JoinColumn(name = "sprint_id")
    Sprint sprint;

    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
