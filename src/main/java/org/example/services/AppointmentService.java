package org.example.services;
//
import org.example.configs.HibernateUtils;
import org.example.configs.InvalidFormatException;
import org.example.configs.InvalidMismatchException;
import org.example.entities.Appointment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class AppointmentService {
    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    public void registerAppointment() throws InvalidFormatException {
        Appointment appointment = new Appointment();
        Scanner input = new Scanner(System.in);

        System.out.println("Type the date for your appointment in  following format : yyyy-MM-dd:");
        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();
        System.out.println("Type the hour for your appointment in  following format : hh:mm:");
        String time = scanner.nextLine();
        try {
            LocalDateTime date1 = LocalDateTime.of(LocalDate.parse(date), LocalTime.parse(time));
            appointment.setDate(date1);
        } catch (Exception e) {
            throw new InvalidFormatException("Invalid format");
        }

        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(appointment);
            transaction.commit();

            System.out.println("Appointment registered successfully: " + appointment);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void displayAllAppointents() throws InvalidMismatchException {

        Session session = sessionFactory.openSession();
        Query<Appointment> query = session.createQuery("SELECT a FROM Appointment a");
        List<Appointment> appointments = query.list();
        if(appointments.size() == 0) {
            throw new InvalidMismatchException("No appointments");
        }else {
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
        session.close();
    }
}