package org.example.services;
//
import org.example.configs.HibernateUtils;
import org.example.entities.Appointment;
import org.example.entities.Owner;
import org.example.entities.Veterinarian;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class VeterinarianService {
    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    public Veterinarian registerVeterinarian(){
        Veterinarian veterinarian = new Veterinarian();
        Scanner input = new Scanner(System.in);

        System.out.println("Type the veterinarian's name:");
        String name = input.nextLine();
        veterinarian.setName(name);

        System.out.println("Type owner's phone number:");
        Integer phoneNumber = input.nextInt();
        veterinarian.setPhoneNumber(phoneNumber);

        System.out.println(veterinarian);

        Session session = sessionFactory.openSession();
        session.persist(veterinarian);
        session.beginTransaction().commit();
        session.close();
        return veterinarian;
    }
    public void displayAllVeterinarians(){
        Session session = sessionFactory.openSession();
        Query<Veterinarian> query = session.createQuery("SELECT v FROM Veterinarian v");
        List<Veterinarian> veterinarians = query.list();
        for (Veterinarian veterinarian : veterinarians){
            System.out.println(veterinarian);
        }
        session.close();
    }
}
