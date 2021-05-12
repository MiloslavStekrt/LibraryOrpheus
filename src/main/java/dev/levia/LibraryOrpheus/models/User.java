package dev.levia.LibraryOrpheus.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table
@Entity
public class User {
    @Id
    @SequenceGenerator(name = "users_sequence", sequenceName = "users_sequence", allocationSize = 1 )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
    private Long id;
    @OneToMany(targetEntity = Event.class, cascade = CascadeType.ALL)
    private List<Event> events = new ArrayList<>();
    @OneToMany(targetEntity = Note.class, cascade = CascadeType.ALL)
    private List<Note> notes = new ArrayList<>();
    @OneToMany(targetEntity = Person.class, cascade = CascadeType.ALL)
    private List<Person> persons = new ArrayList<>();

    private String passwordHash;
    private String uid;
    
    // Getters
    public String getPasswordHash() { return passwordHash; }
    public String getUid() { return uid; }

    // Setters
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public void setUid(String uid) { this.uid = uid; }

    // Manipulation with Events
    public void addEvent(Event event) { events.add(event); }
    public void removeEvent(Event event) { events.remove(event); }
    public void dropEvents() { events.clear(); } 
    public List<Event> getEvents() { return events; }

    // Manipulation with Notes
    public void addNote(Note note) { notes.add(note); }
    public void removeNote(Note note) { notes.remove(note); }
    public void dropNotes() { notes.clear(); }
    public List<Note> getNotes() { return notes; }

    // Manipulation with Persons
    public void addPerson(Person person) { persons.add(person); }
    public void removePerson(Person person) { persons.remove(person); }
    public void dropPersons() { persons.clear(); }
    public List<Person> getPersons() { return persons; }

}
