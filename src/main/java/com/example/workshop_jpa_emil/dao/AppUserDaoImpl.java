package com.example.workshop_jpa_emil.dao;

import com.example.workshop_jpa_emil.models.AppUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Optional;

@Repository
public class AppUserDaoImpl implements AppUserDao {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional
    public AppUser persist(AppUser appUser) {
        entityManager.persist(appUser);
        return appUser;
    }

    @Override
    @Transactional(readOnly= true)
    public Optional findById(int id) {
        return Optional.ofNullable(entityManager.find(AppUser.class, id));
    }

    @Override
    @Transactional(readOnly = true)
    public Collection findAll() {
        return entityManager.createQuery("select s from AppUser s", AppUser.class).getResultList();
    }

    @Override
    @Transactional
    public AppUser update(AppUser appUser) {
        return entityManager.merge(appUser);
    }

    @Override
    public void delete(int id) {
        AppUser appUser = entityManager.find(AppUser.class, id);
        if (appUser != null) entityManager.remove(appUser);

    }
}
