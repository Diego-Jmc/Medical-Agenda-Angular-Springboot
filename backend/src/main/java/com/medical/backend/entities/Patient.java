package com.medical.backend.entities;


import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String documentId;
    private String name;
    private String lastname;
    private String phone;
    private float weight;
    private float height;
    private LocalTime birthDate;


    @ManyToMany
    @JoinTable(
            name = "patient_patology",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "patology_id")
    )
    private List<Patology> patologies;



    public List<Patology> getPatologies() {
        return patologies;
    }

    public void setPatologies(List<Patology> patologies) {
        this.patologies = patologies;
    }

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public LocalTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalTime birthDate) {
        this.birthDate = birthDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", birthDate=" + birthDate +
                ", user=" + user +
                '}';
    }
}
