package com.example.workshop_jpa_emil.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;
    @Column(nullable = false, length = 100, unique = true)
    private String username;
    @Column(nullable = false,length = 100)
    private String password;
    @Column(nullable = false)
    private LocalDate regdate;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "details_id")
    private Details details;


    public AppUser(int id, String username, LocalDate regdate) {
        this.id = id;
        this.username = username;
        this.regdate = regdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getRegdate() {
        return regdate;
    }

    public void setRegdate(LocalDate regdate) {
        this.regdate = regdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return id == appUser.id && username.equals(appUser.username) && password.equals(appUser.password) && regdate.equals(appUser.regdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, regdate);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", regdate=" + regdate +
                '}';
    }
}
