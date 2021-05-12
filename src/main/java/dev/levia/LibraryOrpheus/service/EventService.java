package dev.levia.LibraryOrpheus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.levia.LibraryOrpheus.repo.EventRepository;
import dev.levia.LibraryOrpheus.models.Event;

@Service
public class EventService {
    
    private final EventRepository repo;
    @Autowired
    public EventService(EventRepository repo) { this.repo = repo; }

    public Event getEvent(Long id) {
        return (Event)repo.findById(id).orElseThrow(
            () -> new IllegalArgumentException("Event with id("+id+") doesn't exist")
        );
    }
    public void addEvent(Event event) {
        repo.save(event);
    }
    public List<Event> getEventsJson() {
        return repo.findAll();
    }
}
