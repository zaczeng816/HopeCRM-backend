package com.hopefund.crm.entities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import com.hopefund.crm.entities.enums.AppointmentStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "appointment")
public class Appointment {
    private long id;
    private Client client;
    private LocalDateTime time;
    private List<Duration> notifications;
    private AppointmentStatus status;
    private String personInCharge;
    private String note;
    private String comment;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    public Client getClient(){ return client; }
    public void setClient( Client client ){ this.client = client; }

    @Column(name = "time", nullable = false)
    public LocalDateTime getTime() { return time; }
    public void setTime(LocalDateTime time) { this.time = time; }

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

    @Column(name = "note")
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    @Column(name = "comment")
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
}
