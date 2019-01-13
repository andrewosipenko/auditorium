package com.ao.auditorium.model.course;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String login;
    private String name;
    private String email;

    public User() {
    }

    public User(String login, String name, String email){
        this.login = login;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
