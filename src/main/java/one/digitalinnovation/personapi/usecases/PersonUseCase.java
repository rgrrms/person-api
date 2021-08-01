package one.digitalinnovation.personapi.usecases;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.domain.entities.PersonEntity;
import one.digitalinnovation.personapi.entrypoints.converters.ListPersonEntityToListPersonDtoConverter;
import one.digitalinnovation.personapi.entrypoints.converters.PersonEntityToPersonDtoConverter;
import one.digitalinnovation.personapi.entrypoints.converters.PersonInDtoToPersonEntityConverter;
import one.digitalinnovation.personapi.entrypoints.dto.PersonIdOutDto;
import one.digitalinnovation.personapi.entrypoints.dto.PersonDto;
import one.digitalinnovation.personapi.infrastructure.exceptions.NotFoundException;
import one.digitalinnovation.personapi.infrastructure.services.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonUseCase {

    private final PersonService personService;
    private final ListPersonEntityToListPersonDtoConverter listPersonEntityToListPersonDtoConverter;
    private final PersonEntityToPersonDtoConverter personEntityToPersonDtoConverter;
    private final PersonInDtoToPersonEntityConverter personInDtoToPersonEntityConverter;

    public Optional<List<PersonDto>> getAllPerson() {
        return personService.findAllPerson().map(listPersonEntityToListPersonDtoConverter::convert);
    }

    public Optional<PersonDto> getPerson(Long id) {
        return personService.findPerson(id).map(personEntityToPersonDtoConverter::convert);
    }

    public PersonIdOutDto savePerson(PersonDto person) {
        PersonEntity personEntity = personInDtoToPersonEntityConverter.convert(person);
        PersonEntity personSave = personService.save(personEntity);
        PersonIdOutDto dto = new PersonIdOutDto();
        dto.setId(personSave.getId());
        return dto;
    }

    public PersonIdOutDto alterPerson(Long id, PersonDto person) {
        personService.findPerson(id).orElseThrow(NotFoundException::new);
        PersonEntity personEntity = personInDtoToPersonEntityConverter.convert(person);
        PersonEntity personUpdate = personService.save(personEntity);
        PersonIdOutDto dto = new PersonIdOutDto();
        dto.setId(personUpdate.getId());
        return dto;
    }

    public void deletePerson(Long id) {
        personService.findPerson(id).orElseThrow(NotFoundException::new);
        personService.deletePerson(id);
    }
}