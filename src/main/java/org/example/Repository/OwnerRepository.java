package org.example.Repository;

import org.example.configs.HibernateUtils;
import org.example.configs.InvalidMismatchException;
import org.example.entities.Owner;
import org.example.entities.Veterinarian;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class OwnerRepository {
    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    Transaction transaction = null;
    public void saveOwner(Owner owner){
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(owner);
            transaction.commit();

            System.out.println("Owner registered successfully:\n " + owner);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Owner getOwnerByName(String ownerName){
        try (Session ownerSession = sessionFactory.openSession()){
            Query<Owner> selectOwner = ownerSession.createQuery("SELECT o FROM Owner o WHERE name= :nameOwner");
            selectOwner.setParameter("nameVet",ownerName);
            return selectOwner.getSingleResult();
        } catch (Exception e){
            throw new InvalidMismatchException("Owner not found");

        }
    }
}
