package fr.insee.tulipe.repository;

import fr.insee.tulipe.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
