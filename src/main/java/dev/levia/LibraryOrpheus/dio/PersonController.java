package dev.levia.LibraryOrpheus.dio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

import dev.levia.LibraryOrpheus.models.Person;
import dev.levia.LibraryOrpheus.own.NavLink;
import dev.levia.LibraryOrpheus.service.PersonService;

@Controller
@RequestMapping( path = "/person" )
public class PersonController {

    private final PersonService service;
    
    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    public String getPersonsJson(Model m) {
        m.addAttribute("persons", service.getPersonsJson().toArray());
        m.addAttribute("navlinks", navigation(1));
        return "users";
    }
    
    @PostMapping("/new")
    public void addNewStudent(@RequestBody Person person) {
        service.addPerson(person);
    }
    
    @GetMapping(path="{id}")
    public String getPersonJson( @PathVariable("id") Long id, Model m ) {
        m.addAttribute("selectedPerson", service.getPersonById(id));
        m.addAttribute("persons", service.getPersonsJson().toArray());
        m.addAttribute("navlinks", navigation(1));
        return "users";
    }

    @GetMapping(path="{id}/upload")
    public String uploadImgById( @PathVariable("id") Long id, Model m ) {
        Person person = service.getPersonById(id);
        m.addAttribute("urls", person.getUrls().split(", "));
        m.addAttribute("person", service.getPersonById(id));
        return "upload_img";
    }

    @PostMapping(path="{id}/update")
    public void updatPerson( @PathVariable("id") Long id, Person person ) {
        service.updatePersonById(id, person);
    }

    @PostMapping(path="{id}/saveimg")
    public void saveImgById( @PathVariable("id") Long id, @RequestBody String urls) {
        Person person = service.getPersonById(id);

        person.addPicture(urls);
    }

    public NavLink[] navigation(int role) {
        if (role == 1) {
            return new NavLink[] {
                new NavLink("/person", "Persons"),
                new NavLink("/school", "School"),
                new NavLink("/event", "Events"),
                new NavLink("/pet", "Pets")
            };
        }
        return new NavLink[] {
            new NavLink("/log", "Login"),
            new NavLink("reg", "Register")
        };
    }
}
