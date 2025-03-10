package org.example.entities;
//
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ownerId;
    private String name;
    private String adress;
    private Integer phoneNumber;
    @OneToMany(mappedBy = "owner")
    private List<Pet> petList;

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

    public void setAdress(String address) {
        this.adress = address;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Owner{");
        sb.append("ownerId=").append(ownerId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", address='").append(adress).append('\'');
        sb.append(", phoneNumber=").append(phoneNumber);
        //sb.append(", petList=").append(petList);
        sb.append('}');
        return sb.toString();
    }
}
