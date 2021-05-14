package dev.levia.LibraryOrpheus.dio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.levia.LibraryOrpheus.service.PersonService;

@RestController
public class PersonRestController {
    private final PersonService service;

    @Autowired
    public PersonRestController(PersonService service) {
        this.service = service;
    }

    @PostMapping(value = "/create")
    @RequestMapping( value = "/create", method = RequestMethod.POST)
    public void newUserForm(@RequestBody String person) {
        System.out.println(person);
    }
}
