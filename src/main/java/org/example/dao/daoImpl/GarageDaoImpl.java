package org.example.dao.daoImpl;

import org.example.Entity.Company;
import org.example.Entity.Garage;
import org.example.config.Util;
import org.example.dao.GarageDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GarageDaoImpl implements GarageDao {
    SessionFactory sessionFactory = Util.getSessionFactory();
    @Override
    public void createTables() {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.createSQLQuery("create table if not exists Garage(" +
                    "id serial primary key," +
                    "name varchar not null," +
                    "isEmpty varchar not null)").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
           Garage garage= session.get(Garage.class, id);
            System.out.println(garage);
            if (garage != null) {
                session.delete(garage);
            }else {
                System.out.println("Not found id " + id);
            }
            session.getTransaction().commit();

            System.out.println("User with id: " + id + " successfully deleted!");
        }
    }

    @Override
    public void saveGarage(Garage garage) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(garage);
            session.getTransaction().commit();
        }
    }
}
