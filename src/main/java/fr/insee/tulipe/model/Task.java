package fr.insee.tulipe.model;

import jakarta.persistence.*;

@Entity
public class Task extends ArtefactAgile {
    int points;
    @Enumerated(EnumType.STRING)
    TaskStatus status;
    @ManyToOne
    @JoinColumn(name = "user_story_id")
    private UserStory userStory;

    public UserStory getUserStory() {
        return userStory;
    }

    public void setUserStory(UserStory userStory) {
        this.userStory = userStory;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
