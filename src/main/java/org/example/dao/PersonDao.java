package org.example.dao;

import org.example.Entity.Car;
import org.example.Entity.Person;

public interface PersonDao {
    void createTables();

    void deleteById(Long id);

    void savePerson(Person person);
}
