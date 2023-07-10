package com.hopefund.crm.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.hopefund.crm.entities.enums.ClientStatus;
import com.hopefund.crm.entities.enums.ClientType;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "client")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Client {
        private Long id;
        private String name;
        private String phone;
        private String wechatId;
        private ClientType type = ClientType.POTENTIAL;
        private ClientStatus status = ClientStatus.JOINED;
        private String address;
        private List<Appointment> appointments = new ArrayList<>();
        private LocalDateTime lastFollowupTime;
        private String note;
        private List<Client> friends = new ArrayList<>();

        public Client() {}
        public Client(String name, String phone, String wechatId, ClientType type, ClientStatus status, String address, String note){
                this.name = name;
                this.phone = phone;
                this.wechatId = wechatId;
                this.type = type;
                this.status = status;
                this.address = address;
                this.note = note;
                this.appointments = new ArrayList<>();
                this.friends = new ArrayList<>();
        }
        public String toString(){
                return "Client: " + this.name + ", " + this.phone + ", " + this.wechatId + ", " + this.type + ", " + this.status + ", " + this.address + ", " + this.note;
        }

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        public Long getId() { return id; }
        public void setId(Long id){this.id = id;}

        @Column(name = "name", nullable = false)
        public String getName(){ return name; }
        public void setName(String name){ this.name = name; }

        @Column(name = "phone", nullable = true)
        public String getPhone(){ return phone; }
        public void setPhone(String phone){ this.phone = phone; }

        @Column(name = "wechat_id", nullable = true)
        public String getWechatId(){ return wechatId; }
        public void setWechatId(String wechatId){ this.wechatId = wechatId; }

        @Enumerated(EnumType.STRING)
        @Column(name = "type", nullable = false)
        public ClientType getType(){ return type; }
        public void setType(ClientType type){ this.type = type; }

        @Enumerated(EnumType.STRING)
        @Column(name = "status", nullable = false)
        public ClientStatus getStatus(){ return status; }
        public void setStatus(ClientStatus status){ this.status = status; }

        @Column(name = "address")
        public String getAddress(){ return address; }
        public void setAddress(String address){ this.address = address; }

        @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
        @JsonManagedReference
        public List<Appointment> getAppointments(){ return appointments; }
        public void setAppointments(List<Appointment> appointments){ this.appointments = appointments; }

        @Column(name = "note")
        public String getNote(){ return note; }
        public void setNote(String note){ this.note = note; }

        @ManyToMany
        @JoinTable(
                name = "client_friends",
                joinColumns = @JoinColumn(name = "client_id"),
                inverseJoinColumns = @JoinColumn(name = "friend_id")
        )
        public List<Client> getFriends(){ return friends; }
        public void setFriends(List<Client> friends){ this.friends = friends; }

        @Column(name = "last_followup_time")
        public LocalDateTime getLastFollowupTime(){ return lastFollowupTime; }
        public void setLastFollowupTime(LocalDateTime lastCheckinTime){ this.lastFollowupTime = lastCheckinTime; }
}
