package org.example.dao.daoImpl;

import org.example.Entity.Garage;
import org.example.Entity.Person;
import org.example.config.Util;
import org.example.dao.PersonDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PersonDaoImpl implements PersonDao {
    SessionFactory sessionFactory = Util.getSessionFactory();

    @Override
    public void createTables() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createSQLQuery("create table if not exists Person(" +
                    "id serial primary key," +
                    "name varchar(25) not null," +
                    "age int not null," +
                    "email varchar unique not null," +
                    "gender varchar not null)").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            Person person = session.get(Person.class, id);
            System.out.println(person);
            if (person != null) {
                session.delete(person);
            } else {
                System.out.println("Not found id " + id);
            }
            session.getTransaction().commit();

            System.out.println("User with id: " + id + " successfully deleted!");
        }
    }

    @Override
    public void savePerson(Person person) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(person);
            session.getTransaction().commit();
        }
    }
}
