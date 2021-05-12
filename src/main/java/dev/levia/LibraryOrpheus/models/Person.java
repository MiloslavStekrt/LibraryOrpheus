package dev.levia.LibraryOrpheus.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import dev.levia.LibraryOrpheus.own.Gender;

@Entity
@Table
public class Person {
    
    @Id
    @SequenceGenerator( name = "person_sequence", sequenceName = "person_sequence", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "person_sequence" )
    private Long id;
    
    private String name, eyeColor, email, mobile, abLearn, fvColor, ownStyle, urls;

    @ManyToMany(targetEntity = Event.class)
    private Set<Event> events = new HashSet<>();

    @OneToMany(targetEntity = Note.class, cascade = CascadeType.ALL)
    private Set<Note> notes = new HashSet<>();
    
    private Gender gender; 
    private double wight, height;

    @Transient
    private List<String> pictureUrls;

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getMobile() { return mobile; }
    public String getAbLearn() { return abLearn; }
    public String getFvColor() { return fvColor; }
    public String getEyeColor() { return eyeColor; }
    public String getOwnStyle() { return ownStyle; }
    public List<String> getPictureUrls() { return pictureUrls; }
    public String getUrls() { 
        try {
            this.urls = pictureUrls.toString(); 
            return this.urls;
        } catch (NullPointerException e) {
            return "";
        }
    }

    public Gender getGender() { return gender; }
    public double getWight() { return wight; }
    public double getHeight() { return height; }

    // Setters
    public void setName( String name ) { this.name = name; }
    public void setEmail( String email ) { this.email = email; }
    public void setMobile( String mobile) { this.mobile = mobile; }
    public void setAbLearn( String abLearn ) { this.abLearn = abLearn; }
    public void setFvColor( String fvColor ) { this.fvColor = fvColor; }
    public void setEyeColor( String eyeColor ) { this.eyeColor = eyeColor; }
    public void setOwnStyle( String ownStyle ) { this.ownStyle = ownStyle; }

    public void setWight( double wight ) { this.wight = wight; }
    public void setHeight( double height ) { this.height = height; }
    public void setGender( String gender ) { this.gender = Gender.valueOf(gender.toUpperCase()); }

    // Manipulation with Picture
    public void addPicture( String url ) {
        pictureUrls.add(url);
    }
    public void removePicture( String url ) {
        pictureUrls.remove(url);
    }

    // Manipulation with notes
    public void addNote(Note note) {
        System.out.println(this!= null);
        if(note != null)
            notes.add(note); 
        else throw new IllegalArgumentException("This is not "+note+" a Note Object");
    }
    public void removeNote(Note note) { notes.remove(note); }
    public void dropNotes() { notes.clear(); }
    public Set<Note> getNotes() { return notes; }


    // Manipulation with Events 
    public void addEvent(Event event) { 
        if(event != null)
            events.add(event); 
        else throw new IllegalArgumentException("this is "+event+"not a Event Object");
    }
    public void removeEvent(Event event) { events.remove(event); }
    public void dropEvents(){ events.clear(); }
    public Set<Event> getEvents() { return events; }
    
    // Constructors
    public Person(String name, String email, String mobile, String abLearn, String fvColor,
                String eyeColor, String ownStyle, String gender, double wight, double height, String pictureUrlString) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.abLearn = abLearn;
        this.fvColor = fvColor;
        this.eyeColor = eyeColor;
        this.ownStyle = ownStyle;
        setGender(gender);
        this.wight = wight;
        this.height = height;
        this.pictureUrls = List.of(pictureUrlString.split(", "));
        this.urls = pictureUrlString;
    }
    public Person(String name, String email, String gender) {
        this.name = name;
        this.email = email;
        setGender(gender);
    }
    public Person() {}

    public String toString() {
        return " Person{ name: "+this.name+", email: "+this.email+", gender: "+this.gender+" }";
    }
}
