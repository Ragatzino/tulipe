package fr.insee.tulipe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SprintNotFoundException extends RuntimeException {
    public SprintNotFoundException(String message) {
        super(message);
    }
}
