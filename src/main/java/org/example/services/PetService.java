package org.example.services;

import org.example.configs.HibernateUtils;
import org.example.entities.Pet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class PetService {
    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    public void registerPet() {
        Pet pet = new Pet();
        Scanner input = new Scanner(System.in);

        System.out.println("Type your pet's name: ");
        String name = input.nextLine();
        pet.setName(name);

        System.out.println("Type your pet's age: ");
        int age = input.nextInt();
        input.nextLine();
        pet.setAge(age);

        System.out.println("Type your pet's breed: ");
        String breed = input.nextLine();
        pet.setBreed(breed);

        System.out.println(pet);

        OwnerService ownerService = new OwnerService();
        pet.setOwner(ownerService.registerOwner());
        Session session = sessionFactory.openSession();
        session.persist(pet);
        session.beginTransaction().commit();
        session.close();
    }

    public void displayAllPets(){
        try(Session session = sessionFactory.openSession()){
            Query<Pet> query = session.createQuery("SELECT p FROM Pet p", Pet.class);
            List<Pet> pets = query.list();
            for (Pet pet : pets){
                System.out.println(pet);
            }
        }
    }

}
