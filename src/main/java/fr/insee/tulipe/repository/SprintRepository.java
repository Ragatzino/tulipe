package fr.insee.tulipe.repository;

import fr.insee.tulipe.model.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintRepository extends JpaRepository<Sprint, Integer> {
}
