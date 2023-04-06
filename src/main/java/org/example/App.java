package org.example;

import org.example.entity.Aircrafts;
import org.example.entity.Flights;
import org.example.entity.Seats;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class App 
{
    public static void main( String[] args )
    {

        Configuration configuration=new Configuration()
                .addAnnotatedClass(Seats.class)
                .addAnnotatedClass(Aircrafts.class)
                .addAnnotatedClass(Flights.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();


        System.out.println("модель самолёта с id = 1:");
        Aircrafts Sam = session.get(Aircrafts.class, 1);
        System.out.println(Sam.getModel());

        session.close();

    }
}
