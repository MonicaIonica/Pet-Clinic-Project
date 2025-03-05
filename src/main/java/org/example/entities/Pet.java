package org.example.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer petId;
    private String name;
    private Integer age;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    private String breed;
    @OneToMany(mappedBy = "pet")
    private List<Appointment> appointmentList;

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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pet{");
        sb.append("petId=").append(petId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", owner=").append(owner);
        sb.append(", breed='").append(breed).append('\'');
        sb.append(", appointmentList=").append(appointmentList);
        sb.append('}');
        return sb.toString();
    }
}
