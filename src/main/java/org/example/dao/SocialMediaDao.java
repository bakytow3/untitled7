package org.example.dao;

import org.example.Entity.Car;
import org.example.Entity.SocialMedia;

public interface SocialMediaDao {
    void createTables();

    void deleteById(Long id);

    void saveSocialMediaDao(SocialMedia socialMedia);
}
