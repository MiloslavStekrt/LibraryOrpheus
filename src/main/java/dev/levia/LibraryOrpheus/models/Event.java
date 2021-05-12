package dev.levia.LibraryOrpheus.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Event {

    @Id
    @SequenceGenerator( name = "event_sequence", sequenceName = "event_sequence", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "event_sequence" )
    private Long id; 

    private String title, moreInfo;
    private Date fromDate, toDate;

    // Getters 
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getMoreInfo() { return moreInfo; }
    public Date getFrom() { return fromDate; }
    public Date getTo() { return toDate; }

    // Setters 
    public void setTitle(String title) { this.title = title; }
    public void setMoreInfo(String moreInfo) { this.moreInfo = moreInfo; }
    public void setFrom(Date fromDate) { this.fromDate = fromDate; }
    public void setTo(Date toDate) { this.toDate = toDate; }

    // Constructers 
    public Event() {}

    public Event(String title, String moreInfo) {
        this.title = title;
        this.moreInfo = moreInfo;
    }

    public Event(String title, String moreInfo, Date fromDate, Date toDate) {
        this.title = title;
        this.moreInfo = moreInfo;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

}
