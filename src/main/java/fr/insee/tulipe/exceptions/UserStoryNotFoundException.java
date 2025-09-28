package fr.insee.tulipe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserStoryNotFoundException extends RuntimeException {
    public UserStoryNotFoundException(String message) {
        super(message);
    }
}
