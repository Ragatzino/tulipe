package fr.insee.tulipe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import org.springframework.stereotype.Repository;

import java.util.List;

@Entity
public class Epic extends ArtefactAgile {
    @OneToMany
    List<UserStory> userStories;
}
