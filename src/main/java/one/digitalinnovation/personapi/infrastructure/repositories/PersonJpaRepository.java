package one.digitalinnovation.personapi.infrastructure.repositories;

import one.digitalinnovation.personapi.domain.entities.PersonEntity;
import one.digitalinnovation.personapi.domain.repositories.PersonRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonJpaRepository extends JpaRepository<PersonEntity, Long>, PersonRepository {
}
