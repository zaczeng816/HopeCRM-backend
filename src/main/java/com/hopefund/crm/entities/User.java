package com.hopefund.crm.entities;

import jakarta.persistence.*;
@Entity
@Table(name = "users")
public class User {
    private long id;
    private String name;
    private long phone;
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId(){ return id; }
    public void setId(long id){ this.id = id; }

    @Column(name = "name", nullable = false)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Column(name = "phone", nullable = false)
    public long getPhone() { return phone; }
    public void setPhone(long phone) { this.phone = phone; }

    @Column(name = "password", nullable = false)
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}