package com.hopefund.crm.entity;

import javax.persistence.*;

@Entity
public class User {
    @Id
    private String id;
    private String name;
    private String password;
}
