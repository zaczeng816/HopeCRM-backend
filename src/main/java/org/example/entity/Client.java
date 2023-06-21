package org.example.entity;

import javax.persistence.*;
import java.util.List;

@Entity public class Client {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private String name;
        private long phone;
        private String wechatId;
        private int type;
        private String status;
        private String address;
        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<Appointment> appointments;
        private String note;
        @ManyToMany
        private List<Client> associations;

        // getters and setters...
}


