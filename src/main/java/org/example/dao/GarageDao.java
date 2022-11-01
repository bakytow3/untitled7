package org.example.dao;

import org.example.Entity.Car;
import org.example.Entity.Garage;

public interface GarageDao {
    void createTables();

    void deleteById(Long id);

    void saveGarage(Garage garage);
}
