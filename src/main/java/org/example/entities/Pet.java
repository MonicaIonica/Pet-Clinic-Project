package org.example.entities;

import jakarta.persistence.*;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer petId;
    private String name;
    private Integer age;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner ownerId;
    private String breed;
    @OneToMany
    @JoinColumn(name = "appointment_id")
    private Appointment appointmentID;


    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Owner getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Owner ownerId) {
        this.ownerId = ownerId;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Appointment getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(Appointment appointmentID) {
        this.appointmentID = appointmentID;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", ownerId=" + ownerId +
                ", breed='" + breed + '\'' +
                ", appointmentID=" + appointmentID +
                '}';
    }
}
