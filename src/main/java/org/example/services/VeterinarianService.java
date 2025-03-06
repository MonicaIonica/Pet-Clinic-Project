package org.example.services;
//
import org.example.configs.HibernateUtils;
import org.hibernate.SessionFactory;

public class VeterinarianService {
    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

}
