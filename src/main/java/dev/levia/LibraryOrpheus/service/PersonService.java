package dev.levia.LibraryOrpheus.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.levia.LibraryOrpheus.repo.PersonRepository;
import dev.levia.LibraryOrpheus.models.Event;
import dev.levia.LibraryOrpheus.models.Note;
import dev.levia.LibraryOrpheus.models.Person;

@Service
public class PersonService {
    private final PersonRepository repo;

    @Autowired
    public PersonService(PersonRepository repo) { this.repo = repo; }

    public void delPersonById(Long id) {
        Person delPerson = repo.findById(id).get();
        delPerson.dropNotes();
        repo.saveAndFlush(delPerson);
        repo.deleteById(id);
    }
	public List<Person> getPersonsJson() {
		return repo.findAll();
	}
	public Person getPersonById(Long id) {
		return repo.findById(id).orElseThrow(
            () -> new IllegalStateException("Student with id("+id+") doesn't exist")
        );
	}
    public void updatePersonById(Long id, Person person) {
        if (!repo.findById(id).isPresent()) 
            throw new IllegalStateException("Person with id("+id+") is not in DB");
        
        Person noEdited = repo.findById(id).get();
        noEdited.setAbLearn(person.getAbLearn());
        noEdited.setEmail(person.getEmail());
        noEdited.setEyeColor(person.getEyeColor());
        noEdited.setFvColor(person.getFvColor());
        noEdited.setGender(String.valueOf(person.getGender()));
        noEdited.setHeight(person.getHeight());
        noEdited.setMobile(person.getMobile());
        noEdited.setName(person.getName());
        noEdited.setOwnStyle(person.getOwnStyle());
        noEdited.setWight(person.getWight());
        repo.save(noEdited);
    }
	public void addPerson(Person person) {
        repo.save(person);
	}
    public Event[] getEvents(Long id) {
        return (Event[]) repo.findById(id).get()
            .getEvents().toArray();
    }
	public Person newEmptyPerson() {
		return new Person();
	}
    public Set<Note> getNotes(Long id) {
        return repo.findById(id).get().getNotes();
    }

    public void save(Person person) {
        repo.save(person);
    }
    
}
