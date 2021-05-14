package dev.levia.LibraryOrpheus.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.levia.LibraryOrpheus.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    // @Query(value="delete from ")
    // Optional<Person> getPersonIdByNoteId( Long id );

}
