package fr.insee.tulipe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Sprint extends ArtefactAgile{

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateDebut;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateFin;
    @OneToMany
    List<UserStory> userStoriesDuSprint;

    public List<UserStory> getUserStoriesDuSprint() {
        return userStoriesDuSprint;
    }

    public void setUserStoriesDuSprint(List<UserStory> userStoriesDuSprint) {
        this.userStoriesDuSprint = userStoriesDuSprint;
    }
    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Sprint sprint = (Sprint) o;
        return Objects.equals(getId(), sprint.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getDateDebut());
    }
}
