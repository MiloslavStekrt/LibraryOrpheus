package dev.levia.LibraryOrpheus.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.levia.LibraryOrpheus.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
