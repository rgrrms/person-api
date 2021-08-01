package one.digitalinnovation.personapi.infrastructure.services;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.domain.entities.PersonEntity;
import one.digitalinnovation.personapi.infrastructure.repositories.PersonJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonJpaRepository personJpaRepository;

    public Optional<List<PersonEntity>> findAllPerson() {
        return Optional.of(personJpaRepository.findAll());
    }

    public Optional<PersonEntity> findPerson(Long id) {
        return personJpaRepository.findById(id);
    }

    public PersonEntity save(PersonEntity person) {
        return personJpaRepository.save(person);
    }

    public void deletePerson(Long id) {
        personJpaRepository.deleteById(id);
    }
}
