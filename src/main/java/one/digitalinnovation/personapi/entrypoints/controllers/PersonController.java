package one.digitalinnovation.personapi.entrypoints.controllers;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.entrypoints.controllers.documentation.PersonDocumentation;
import one.digitalinnovation.personapi.entrypoints.dto.PersonOutDto;
import one.digitalinnovation.personapi.infrastructure.exceptions.NotFoundException;
import one.digitalinnovation.personapi.usecases.PersonUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
@CrossOrigin
@AllArgsConstructor
public class PersonController implements PersonDocumentation {

    private final PersonUseCase personUseCase;

    @Override
    @GetMapping
    public ResponseEntity<List<PersonOutDto>> getAllPerson() {
        return personUseCase.getAllPerson().map(ResponseEntity::ok).orElseThrow(NotFoundException::new);
    }
}
