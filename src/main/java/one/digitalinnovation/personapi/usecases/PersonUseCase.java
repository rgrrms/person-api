package one.digitalinnovation.personapi.usecases;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.entrypoints.converters.ListPersonOutDtoToListPersonEntityConverter;
import one.digitalinnovation.personapi.entrypoints.dto.PersonOutDto;
import one.digitalinnovation.personapi.infrastructure.services.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonUseCase {

    private final PersonService personService;
    private final ListPersonOutDtoToListPersonEntityConverter converter;

    public Optional<List<PersonOutDto>> getAllPerson() {
        return personService.findAllPerson().map(converter::convert);
    }
}
