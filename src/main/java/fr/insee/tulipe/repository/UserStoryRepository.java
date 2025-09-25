package fr.insee.tulipe.repository;

import fr.insee.tulipe.model.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStoryRepository extends JpaRepository<UserStory, Integer> {
}
