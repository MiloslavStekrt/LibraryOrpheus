package dev.levia.LibraryOrpheus.conf;

// import java.util.List;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Bean;
// import dev.levia.LibraryOrpheus.models.*;
// import dev.levia.LibraryOrpheus.repo.NoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import dev.levia.LibraryOrpheus.repo.EventRepository;
import dev.levia.LibraryOrpheus.repo.PersonRepository;
import dev.levia.LibraryOrpheus.repo.UserRepository;

@Configuration
public class SeederConf {
    
    @Autowired
    private PersonRepository person;
    
    @Autowired
    private EventRepository event;
    
    @Autowired
    private UserRepository user;

    // @Bean
    // CommandLineRunner commandLineRunner() {
    //     return args -> {
    //         User admin = new User("merlin", "AdminLuser");
    //         Person johnwick = new Person("John wick", "john@wick", "MAN");
    //         Person isabela = new Person("Isabel Swon", "bela@swon", "woman");

    //         Note diaryIsabela = new Note("Isabel had nice day");
    //         Event killStrike = new Event("5 new kills", "He just kill someones friends.");

    //         event.save(killStrike);
            
    //         isabela.addNote(diaryIsabela);
    //         johnwick.addEvent(killStrike);
            
    //         person.saveAll(List.of(johnwick, isabela));
    //         user.saveAll(List.of(admin));
    //     };
    // }
    
}
