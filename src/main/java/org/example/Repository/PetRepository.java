package org.example.Repository;

import org.example.configs.HibernateUtils;
import org.example.configs.InvalidMismatchException;
import org.example.entities.Pet;
import org.example.entities.Veterinarian;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class PetRepository {
    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    public Pet getPetByName(String petName){
        try (Session petSession = sessionFactory.openSession()){
            Query<Pet> selectPet = petSession.createQuery("SELECT p FROM Pet p WHERE name= :namePet");
            selectPet.setParameter("namePet", petName);
            return selectPet.getSingleResult();
        } catch (Exception e){
            throw new InvalidMismatchException("Pet not found");

        }
    }
}
