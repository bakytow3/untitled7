package org.example.dao;

import org.example.Entity.Car;
import org.example.Entity.Company;

public interface CompanyDao {
    void createTables();

    void deleteById(Long id);

    void saveCompany(Company company);
}
