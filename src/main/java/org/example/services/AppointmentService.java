package org.example.services;
//
import org.example.Repository.AppointmentRepository;
import org.example.Repository.PetRepository;
import org.example.Repository.VeterinarianRepository;
import org.example.configs.HibernateUtils;
import org.example.configs.InvalidFormatException;
import org.example.configs.InvalidMismatchException;
import org.example.entities.Appointment;
import org.example.entities.Veterinarian;
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


        System.out.println("Type the name of the veterinarian:");
        String vetName = scanner.nextLine();

        VeterinarianRepository vetRep = new VeterinarianRepository();
        appointment.setVeterinarian(vetRep.getVetByName(vetName));

        System.out.println("Type the name of the pet:");
        String petName = scanner.nextLine();


        PetRepository petRep = new PetRepository();

        appointment.setPet(petRep.getPetByName(petName));

        AppointmentRepository appRep =  new AppointmentRepository();
        appRep.saveAppointment(appointment);
    }

    public void displayAllAppointments() throws InvalidMismatchException {
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