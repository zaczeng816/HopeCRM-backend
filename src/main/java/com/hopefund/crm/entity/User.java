package com.hopefund.crm.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "USER")
public class User {
    @Id
    private String id;
    private String name;
    private String password;
}
