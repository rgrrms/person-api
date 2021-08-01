package one.digitalinnovation.personapi.entrypoints.controllers;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.entrypoints.controllers.documentation.PersonDocumentation;
import one.digitalinnovation.personapi.entrypoints.dto.PersonIdOutDto;
import one.digitalinnovation.personapi.entrypoints.dto.PersonDto;
import one.digitalinnovation.personapi.infrastructure.exceptions.NotFoundException;
import one.digitalinnovation.personapi.usecases.PersonUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/person")
@CrossOrigin
@AllArgsConstructor
@Controller
public class PersonController implements PersonDocumentation {

    private final PersonUseCase personUseCase;

    @Override
    @GetMapping
    public ResponseEntity<List<PersonDto>> getAllPerson() {
        return personUseCase.getAllPerson().map(ResponseEntity::ok).orElseThrow(NotFoundException::new);
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity<PersonDto> getPerson(@PathVariable Long id) {
        return personUseCase.getPerson(id).map(ResponseEntity::ok).orElseThrow(NotFoundException::new);
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonIdOutDto savePerson(@RequestBody @Valid PersonDto person) {
        return personUseCase.savePerson(person);
    }

    @Override
    @PutMapping("{id}")
    public PersonIdOutDto alterPerson(@RequestBody @Valid PersonDto person, @PathVariable Long id) {
        return personUseCase.alterPerson(id, person);
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity deletePerson(@PathVariable Long id) {
        personUseCase.deletePerson(id);
        return ResponseEntity.ok().build();
    }
}