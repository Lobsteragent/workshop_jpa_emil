package com.example.workshop_jpa_emil.dao;

import com.example.workshop_jpa_emil.models.AppUser;

import java.util.Collection;
import java.util.Optional;

public interface AppUserDao {
    AppUser persist(AppUser appUser);
    Optional findById(int id);
    Collection findAll();
    AppUser update (AppUser appUser);
    void delete (int id);


}
