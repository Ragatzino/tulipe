package fr.insee.tulipe.repository;

import fr.insee.tulipe.model.Epic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpicRepository extends JpaRepository<Epic, Integer> {
}
