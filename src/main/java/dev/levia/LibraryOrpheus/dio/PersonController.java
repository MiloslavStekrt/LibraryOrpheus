package dev.levia.LibraryOrpheus.dio;

import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import dev.levia.LibraryOrpheus.models.Note;
import dev.levia.LibraryOrpheus.models.Person;
import dev.levia.LibraryOrpheus.own.Gender;
import dev.levia.LibraryOrpheus.own.OperationMethods;
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
        m.addAttribute("selectedPerson", service.newEmptyPerson());
        m.addAttribute("navlinks", OperationMethods.navigation(1));
        return "users";
    }

    @GetMapping(path = "/{id}/note/{note_id}")
    public RedirectView removeNoteFromPerson(@PathVariable("id") Long id, @PathVariable("note_id") Long noteId) {
        Person person = service.getPersonById(id);
        person.removeNote(person.getNoteById(noteId));
        service.save(person);
        return new RedirectView("/person/"+id);
    }

    @PostMapping(path = "/new")
    public RedirectView addNewStudent(
            @ModelAttribute("name") String name,
            @ModelAttribute("wight") String wight,
            @ModelAttribute("height") String height,
            @ModelAttribute("gender") String genderForm,
            @ModelAttribute("eyeColor") String eyeColor,
            @ModelAttribute("email") String email,
            @ModelAttribute("mobile") String mobile,
            @ModelAttribute("abLearn") String abLearn,
            @ModelAttribute("fvColor") String fvColor,
            @ModelAttribute("ownStyle") String ownStyle ) {
        wight = wight != null && wight.length() > 0 ? wight: "0";
        height = height != null && height.length() > 0 ? wight: "0";
        
        Gender gender;
        try { gender = Gender.valueOf(genderForm); } 
        catch (Exception e) { gender = Gender.NONE; }
        
        service.addPerson(
            new Person(name, email, mobile, abLearn, fvColor, eyeColor, ownStyle, gender, 
                Double.parseDouble(wight), Double.parseDouble(height), "")
        );
        return new RedirectView("/person/");
    }

    @PostMapping(path = "{id}/update")
    public RedirectView updatePersonById(
            @PathVariable Long id,
            @ModelAttribute("name") String name,
            @ModelAttribute("wight") String wight,
            @ModelAttribute("height") String height,
            @ModelAttribute("gender") String genderForm,
            @ModelAttribute("eyeColor") String eyeColor,
            @ModelAttribute("email") String email,
            @ModelAttribute("mobile") String mobile,
            @ModelAttribute("abLearn") String abLearn,
            @ModelAttribute("fvColor") String fvColor,
            @ModelAttribute("ownStyle") String ownStyle ) {
        Gender gender;
        try { gender = Gender.valueOf(genderForm.toUpperCase()); } 
        catch (Exception e) { gender = Gender.NONE; }

        wight = wight != null && wight.length() > 0 ? wight: "0";
        wight = height != null && height.length() > 0 ? wight: "0";
        service.updatePersonById(id,
            new Person(name, email, mobile, abLearn, fvColor, eyeColor, ownStyle, gender, 
                Double.parseDouble(wight), Double.parseDouble(height), "")
        );
        return new RedirectView("/person/"+id+"/edit");
    }

    @GetMapping(path = "{id}/delete")
    public RedirectView removePersonById(@PathVariable("id") Long id) {
        service.delPersonById(id);
        return new RedirectView("/person/");
    }

    @GetMapping(path="{id}/edit")
    public String getPersonJson( @PathVariable("id") Long id, Model m ) {
        m.addAttribute("selectedPerson", service.getPersonById(id));
        m.addAttribute("persons", service.getPersonsJson().toArray());
        m.addAttribute("navlinks", OperationMethods.navigation(1));
        return "users";
    }

    @GetMapping(path="{id}/upload")
    public String uploadImgById( @PathVariable("id") Long id, Model m ) {
        Person person = service.getPersonById(id);
        m.addAttribute("urls", person.getUrls().split(", "));
        m.addAttribute("person", service.getPersonById(id));
        return "upload_img";
    }
    
    @GetMapping(path = "{id}")
    public String showNotesById(@PathVariable("id") Long id, Model m) {
        m.addAttribute("navlinks", OperationMethods.navigation(1));
        m.addAttribute("notes", service.getNotes(id).stream().sorted(Comparator.comparing(Note::getWhen, Comparator.nullsLast(Comparator.reverseOrder()))).toArray());
        m.addAttribute("person", service.getPersonById(id));
        m.addAttribute("persons", service.getPersonsJson());
        return "notes";
    }

    @PostMapping(path = "{id}/addnote")
    public RedirectView addNoteToPerson(@PathVariable("id") Long id, Model m, @ModelAttribute("note") String bodyString ) {
        Person person = service.getPersonById(id);
        Note note = new Note(bodyString);
        person.addNote(note);
        service.updatePersonById(id, person);

        // m.addAttribute("navlinks", navigation(1));
        // m.addAttribute("notes", service.getNotes(id));
        // m.addAttribute("person", service.getPersonById(id));
        return new RedirectView("/person/"+id+"/");//"notes";
    }

    @PostMapping(path="{id}/saveimg")
    public void saveImgById( @PathVariable("id") Long id, @RequestBody String urls) {
        Person person = service.getPersonById(id);

        person.addPicture(urls);
    }

}
