package com.hopefund.crm.entity;

import jakarta.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long clientId;
    private LocalDateTime time;
    @ElementCollection
    private List<Duration> notifications;
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;
    private String personInCharge;
    private String note;
    private String comment;

    public enum AppointmentStatus {
        APPOINTED, // 已预约
        FOLLOWING_UP, // 跟进中
        COMPLETED // 完成
    }

}

