package com.hopefund.crm.entities;

import com.hopefund.crm.entities.enums.ClientStatus;
import com.hopefund.crm.entities.enums.ClientType;
import jakarta.persistence.*;
import java.util.Set;


@Entity
@Table(name = "client")
public class Client {
        private long id;
        private String name;
        private long phone;
        private String wechatId;
        private ClientType type;
        private ClientStatus status;
        private String address;
        private Set<Appointment> appointments;
        private String note;
        private Set<Client> friends;
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        public long getId() { return id; }
        public void setId(long id){this.id = id;}

        @Column(name = "name", nullable = false)
        public String getName(){ return name; }
        public void setName(String name){ this.name = name; }

        @Column(name = "phone", nullable = false)
        public long getPhone(){ return phone; }
        public void setPhone(long phone){ this.phone = phone; }

        @Column(name = "wechat_id", nullable = false)
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
        public Set<Appointment> getAppointments(){ return appointments; }
        public void setAppointments(Set<Appointment> appointments){ this.appointments = appointments; }

        @Column(name = "note")
        public String getNote(){ return note; }
        public void setNote(String note){ this.note = note; }

        @ManyToMany
        @JoinTable(
                name = "client_friends",
                joinColumns = @JoinColumn(name = "client_id"),
                inverseJoinColumns = @JoinColumn(name = "friend_id")
        )
        public Set<Client> getFriends(){ return friends; }
        public void setFriends(Set<Client> friends){ this.friends = friends; }
}








