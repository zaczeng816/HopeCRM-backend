package com.hopefund.crm.entities;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.hopefund.crm.entities.enums.AppointmentStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "appointment")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Appointment {
    private Long id;
    private Client client;
    private ZonedDateTime time;
    private List<Duration> notifications = new ArrayList<>();
    private AppointmentStatus status = AppointmentStatus.APPOINTED;
    private String personInCharge = "";
    private String title = "";
    private String note = "";
    private String result = "";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "client_id", nullable = false)
    public Client getClient(){ return client; }
    public void setClient( Client client ){ this.client = client; }

    @Column(name = "time", nullable = false)
    public ZonedDateTime getTime() { return time; }
    public void setTime(ZonedDateTime time) { this.time = time; }

    @ElementCollection
    @CollectionTable(name = "notification", joinColumns = @JoinColumn(name = "appointment_id"))
    @Column(name = "notification")
    public List<Duration> getNotifications() { return notifications; }
    public void setNotifications(List<Duration> notifications) { this.notifications = notifications; }

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    public AppointmentStatus getStatus(){ return status; }
    public void setStatus( AppointmentStatus status ){ this.status = status; }

    @Column(name = "person_in_charge")
    public String getPersonInCharge() { return personInCharge; }
    public void setPersonInCharge(String personInCharge) { this.personInCharge = personInCharge; }

    @Column(name = "title")
    public String getTitle() { return title; }
    public void setTitle(String note) { this.title = note; }

    @Column(name = "note", length=500)
    public String getNote() { return note; }
    public void setNote(String comment) { this.note = comment; }

    @Column(name = "result")
    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
}
