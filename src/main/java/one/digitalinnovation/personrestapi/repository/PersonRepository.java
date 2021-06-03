package one.digitalinnovation.personrestapi.repository;

import one.digitalinnovation.personrestapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
