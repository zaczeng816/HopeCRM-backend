package com.hopefund.crm.entity;

import com.hopefund.crm.entity.Client;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "APPOINTMENT")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
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

