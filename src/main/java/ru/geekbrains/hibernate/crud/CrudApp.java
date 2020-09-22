package ru.geekbrains.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CrudApp {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("configs/crud/hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;

        try {
            System.out.println("========\n==CREATE==\n========");
            session= factory.getCurrentSession();
            session.beginTransaction();
            Buyer buyer = new Buyer("Willis B.");
            session.saveOrUpdate(buyer);
            session.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
            if(session != null) {
                session.close();
            }
        }
    }
}
