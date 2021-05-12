package dev.levia.LibraryOrpheus.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.levia.LibraryOrpheus.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
