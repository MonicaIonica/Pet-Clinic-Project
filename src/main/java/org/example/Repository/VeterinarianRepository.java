package org.example.Repository;

import org.example.configs.HibernateUtils;
import org.example.configs.InvalidMismatchException;
import org.example.entities.Veterinarian;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class VeterinarianRepository {
    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    public Veterinarian getVetByName(String vetName){
        try (Session vetSession = sessionFactory.openSession()){
            Query<Veterinarian> selectVet = vetSession.createQuery("SELECT v FROM Veterinarian v WHERE name= :nameVet");
            selectVet.setParameter("nameVet",vetName);
            return selectVet.getSingleResult();
        } catch (Exception e){
            throw new InvalidMismatchException("Vet not found");

        }
    }
}
