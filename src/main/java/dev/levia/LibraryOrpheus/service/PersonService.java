package dev.levia.LibraryOrpheus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.levia.LibraryOrpheus.repo.PersonRepository;
import dev.levia.LibraryOrpheus.models.Event;
import dev.levia.LibraryOrpheus.models.Person;

@Service
public class PersonService {
    private final PersonRepository repo;

    @Autowired
    public PersonService(PersonRepository repo) { this.repo = repo; }

	public List<Person> getPersonsJson() {
		return repo.findAll();
	}

	public Person getPersonById(Long id) {
		return repo.findById(id).orElseThrow(
            () -> new IllegalStateException("Student with id("+id+") doesn't exist")
        );
	}

    public void updatePersonById(Long id, Person person) {
        if (repo.findById(id).isPresent()) 
            throw new IllegalStateException("Person with id("+id+") is not in DB");

        repo.findById(id).orElseThrow(
            () -> new IllegalStateException("Student with id("+id+") doesn't exist")
        );
    }

	public void addPerson(Person person) {
        repo.save(person);
	}

    public Event[] getEvents(Long id) {
        return (Event[]) repo.findById(id).get()
            .getEvents().toArray();
    }
    
}
