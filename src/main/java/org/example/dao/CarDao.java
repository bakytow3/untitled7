package org.example.dao;

import org.example.Entity.Car;

public interface CarDao {
    void  createTables();

    void deleteById(Long id);

    void saveCar(Car car);
}
