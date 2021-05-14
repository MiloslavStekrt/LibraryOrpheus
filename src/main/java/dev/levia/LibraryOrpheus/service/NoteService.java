package dev.levia.LibraryOrpheus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.levia.LibraryOrpheus.repo.NoteRepository;
import dev.levia.LibraryOrpheus.models.Note;

@Service
public class NoteService {

    private final NoteRepository repo;

    @Autowired
    public NoteService(NoteRepository repo) {
        this.repo = repo; 
    }

    public List<Note> getAllNotes() {
        return repo.findAll();
    }

    public Note getNote(Long id) {
        return repo.findById(id).get();
    }

    // public Optional<Note> deleteNote(Long id) {
    //     return repo.delConnectionByNoteId(id);
    // }

}
