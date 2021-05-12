package dev.levia.LibraryOrpheus.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.levia.LibraryOrpheus.models.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long>{
    
    // @Query(value="SELECT note from Note note WHERE note.when >= ?1 AND note.when <= ?2")
    // Optional<Note> getNotesFromTo( Date from, Date to );

}
