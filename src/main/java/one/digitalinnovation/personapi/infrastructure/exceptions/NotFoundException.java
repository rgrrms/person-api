package one.digitalinnovation.personapi.infrastructure.exceptions;

import one.digitalinnovation.personapi.infrastructure.components.MessagesComponent;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Not Found")
public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super(MessagesComponent.get("exception.NotFound.Person"));
    }
}
