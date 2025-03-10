package org.example.Repository;

import org.example.configs.HibernateUtils;
import org.example.entities.Appointment;
import org.example.entities.Veterinarian;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AppointmentRepository {
    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    Transaction transaction = null;
    public void saveAppointment(Appointment appointment){
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(appointment);
            transaction.commit();

            System.out.println("Appointment registered successfully:\n " + appointment);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
