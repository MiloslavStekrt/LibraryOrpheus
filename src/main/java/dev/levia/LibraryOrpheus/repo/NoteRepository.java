package dev.levia.LibraryOrpheus.repo;

// import java.util.Optional;
// import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.levia.LibraryOrpheus.models.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long>{

    // @Query(value="DELETE FROM person_notes WHERE notes_id = ?1;", nativeQuery = true)
    // Optional<Note> delConnectionByNoteId( Long id );

    // @Query(value="SELECT person_id FROM person_notes WHERE notes_id = ?1;")
    // Optional<Note> getPersonIdByNoteId( Long id );

}
