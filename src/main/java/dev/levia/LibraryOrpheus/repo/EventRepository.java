package dev.levia.LibraryOrpheus.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.levia.LibraryOrpheus.models.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    
    // @Query(value="SELECT person from Person person WHERE person.id = ?1")
    // Optional<Person> getPersonById(Long id);

    // @Query(value="SELECT person from Person person WHERE person = 1")
    // Optional<Person> getAllPersons();

}
