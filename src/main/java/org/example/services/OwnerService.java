package org.example.services;
//
import org.example.configs.HibernateUtils;
import org.example.entities.Owner;
import org.example.entities.Pet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class OwnerService {
    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    public Owner registerOwner(){
        Owner owner = new Owner();
        Scanner input = new Scanner(System.in);

        System.out.println("Type the owner's name:");
        String name = input.nextLine();
        owner.setName(name);

        System.out.println("Type owner's address:");
        String address = input.nextLine();
        owner.setAdress(address);

        System.out.println("Type owner's phone number:");
        Integer phoneNumber = input.nextInt();
        owner.setPhoneNumber(phoneNumber);

        System.out.println(owner);
        Session session = sessionFactory.openSession();
        session.persist(owner);
        session.beginTransaction().commit();
        session.close();
        return owner;
    }
    public void displayAllOwners(){
        Session session = sessionFactory.openSession();
        Query<Owner> query = session.createQuery("SELECT o FROM Owner o");
        List<Owner> owners = query.list();
        for (Owner owner : owners){
            System.out.println(owner);
        }
        session.close();
    }
}


