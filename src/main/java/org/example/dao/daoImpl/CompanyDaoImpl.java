package org.example.dao.daoImpl;

import org.example.Entity.Car;
import org.example.Entity.Company;
import org.example.config.Util;
import org.example.dao.CompanyDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CompanyDaoImpl implements CompanyDao {
    SessionFactory sessionFactory = Util.getSessionFactory();
    @Override
    public void createTables() {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.createSQLQuery("create table if not exists Company(" +
                    "id serial primary key," +
                    "companyName varchar(30) unique not null," +
                    "locaition varchar not null)").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            Company company= session.get(Company.class, id);
            System.out.println(company);
            if (company != null) {
                session.delete(company);
            }else {
                System.out.println("Not found id " + id);
            }
            session.getTransaction().commit();

            System.out.println("User with id: " + id + " successfully deleted!");
        }
    }

    @Override
    public void saveCompany(Company company) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(company);
            session.getTransaction().commit();
        }
    }
    }

