package org.example.entities;


import jakarta.persistence.*;

import java.util.List;
@Entity
public class Veterinarian {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "veterinarian")
    private List<Appointment> appointments;
    private Integer phoneNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Veterinarian{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", appointments=" + appointments +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
