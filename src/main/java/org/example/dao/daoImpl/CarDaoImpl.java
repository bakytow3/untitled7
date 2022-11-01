package org.example.dao.daoImpl;

import org.example.Entity.Car;

import org.example.config.Util;
import org.example.dao.CarDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class CarDaoImpl implements CarDao {
    SessionFactory sessionFactory = Util.getSessionFactory();
    @Override
    public void createTables() {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.createSQLQuery("create table if not exists Car(" +
                    "id serial primary key," +
                    "mark varchar not null," +
                    "producedCountry varchar not null)").executeUpdate();
            session.getTransaction().commit();
        }
    }
    @Override
    public void deleteById(Long id) {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            Car car= session.get(Car.class, id);
            System.out.println(car);
            if (car != null) {
                session.delete(car);
            }else {
                System.out.println("Not found id " + id);
            }
            session.getTransaction().commit();

            System.out.println("User with id: " + id + " successfully deleted!");
        }
    }

    @Override
    public void saveCar(Car car) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(car);
            session.getTransaction().commit();
        }
    }
}
