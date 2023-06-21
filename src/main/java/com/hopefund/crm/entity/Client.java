package com.hopefund.crm.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "CLIENT")
public class Client {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private String name;
        private long phone;
        private String wechatId;
        @Enumerated(EnumType.STRING)
        private ClientType type;
        @Enumerated(EnumType.STRING)
        private ClientStatus status;
        private String address;
        @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
        private Set<Appointment> appointments;
        private String note;
        @ManyToMany(mappedBy = "client")
        private Set<Client> friends;


        public enum ClientType {
                POTENTIAL, // 潜在客户
                REAL // 现实客户
        }
        public enum ClientStatus {
                JOINED, // 进入客服
                INTERESTED, // 有意向
                APPOINTED, // 已约
                FOLLOWING_UP, // 跟进中
                DEAL_CLOSED // 已成交
        }
        // getters and setters...
        public long getId() {
                return id;
        }
        public String getName(){
                return name;
        }
        public void setName(String name){
                this.name = name;
        }
        public long getPhone(){
                return phone;
        }
        public void setPhone(long phone){
                this.phone = phone;
        }
        public String getWechatId(){
                return wechatId;
        }
        public void setWechatId(String wechatId){
                this.wechatId = wechatId;
        }


        public ClientType getType(){
                return type;
        }

}


