package org.example.entity;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long clientId;
    private LocalDateTime time;
    @ElementCollection
    private List<Duration> notifications;
    private String status;
    private String personInCharge;
    private String note;
    private String comment;

}

