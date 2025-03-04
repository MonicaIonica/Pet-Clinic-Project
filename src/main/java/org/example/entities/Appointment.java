package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name= "pet_id")
    private int petId;
    @ManyToOne
    @JoinColumn(name = "veterinarian_id")
    private int veterinarianId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getVeterinarianId() {
        return veterinarianId;
    }

    public void setVeterinarianId(int veterinarianId) {
        this.veterinarianId = veterinarianId;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", date=" + date +
                ", petId=" + petId +
                ", veterinarianId=" + veterinarianId +
                '}';
    }
}
