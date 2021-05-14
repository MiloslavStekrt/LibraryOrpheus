package dev.levia.LibraryOrpheus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.levia.LibraryOrpheus.models.User;
import dev.levia.LibraryOrpheus.repo.UserRepository;

@Service
public class UserService {
    private final UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) { this.repo = repo; }

    public User getUserById(Long id) {
        return repo.findById(id).orElseThrow(() -> new IllegalStateException("User with this id("+id+") doesn't exist.") );
    }
    public List<User> getUsers() { return repo.findAll(); }
    
}
