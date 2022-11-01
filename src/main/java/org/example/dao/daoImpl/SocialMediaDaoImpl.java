package org.example.dao.daoImpl;

import org.example.Entity.Person;
import org.example.Entity.SocialMedia;
import org.example.config.Util;
import org.example.dao.SocialMediaDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SocialMediaDaoImpl implements SocialMediaDao {
    SessionFactory sessionFactory = Util.getSessionFactory();
    @Override
    public void createTables() {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.createSQLQuery("create table if not exists SocialMedia(" +
                    "id serial primary key," +
                    "SocialMedia varchar unique not null)").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
           SocialMedia socialMedia = session.get(SocialMedia.class, id);
            System.out.println(socialMedia);
            if (socialMedia!= null) {
                session.delete(socialMedia);
            } else {
                System.out.println("Not found id " + id);
            }
            session.getTransaction().commit();

            System.out.println("User with id: " + id + " successfully deleted!");
        }
    }

    @Override
    public void saveSocialMediaDao(SocialMedia socialMedia) {

    }
}
