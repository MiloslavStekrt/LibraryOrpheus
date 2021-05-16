package dev.levia.LibraryOrpheus.models;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Note {
    
    @Id
    @SequenceGenerator( name = "note_sequence", sequenceName = "note_sequence", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "note_sequence" )
    private Long id;

    private String note;
//    private Date whenDate;
    private Timestamp whenDate;

    // @ManyToOne
    // @JoinColumn(name = "person_id", updatable = false, insertable = false)
    // private Person person;

    // constructor
    public Note(){}
    public Note(String note) {
        this.note = note;
        this.whenDate = new Timestamp(System.currentTimeMillis());
    }
    public Note(String note, Timestamp whenDate) {
        this.note = note;
        this.whenDate = whenDate;
    }
    
    // Getters
    public Long getId() { return id; }
    public Timestamp getWhen() {
    	return this.whenDate;
    }
    public String getNote() { return note; }
//    @SuppressWarnings("deprecation")
//	public String getWhenNormal() {
//        return this.whenDate.getDay()+". "+this.whenDate.getMonth()+". "
//            +(new java.util.Date().getYear() != this.whenDate.getYear() ? this.whenDate.getYear() - 100 : "");
//    }

    // Setters
    public void setWhen(Timestamp whenDate) { this.whenDate = whenDate; }
    public void setNote(String note) { this.note = note; }
    
    
    // to String methods
    public String toString() {
        return "Note {id: "+this.id
            +",title: "+this.note
            +", when: "+this.whenDate+"}";
    }
    public String toStingDate() {
    	StringBuilder dateformat = new StringBuilder("HH:mm dd. MM. ");
    	Timestamp now = new Timestamp(System.currentTimeMillis());
    	if (now.getYear() != whenDate.getYear()) dateformat.append("yyyy. ");
    	
    	return new SimpleDateFormat(dateformat.toString()).format(this.whenDate);
    }

}
