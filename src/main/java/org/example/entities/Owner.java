package org.example.entities;

import jakarta.persistence.*;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ownerId;
    private String name;
    private String adress;
    private Integer phoneNumber;
    @OneToMany
    @JoinColumn(name = "pet_id")
    private int petId;

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerId=" + ownerId +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", petId=" + petId +
                '}';
    }
}
