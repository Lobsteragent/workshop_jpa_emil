package com.example.workshop_jpa_emil.dao;

import com.example.workshop_jpa_emil.models.Details;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Collection;
import java.util.Optional;
@Repository
public class DetailsDaoImpl implements DetailsDao{

    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional
    public Details persist(Details details) {
        entityManager.persist(details);
        return details;
    }

    @Override
    @Transactional(readOnly= true)
    public Optional findById(int id) {
        return Optional.ofNullable(entityManager.find(Details.class, id));
    }

    @Override
    @Transactional(readOnly = true)
    public Collection findAll() {
        return entityManager.createQuery("select s from Details s", Details.class).getResultList();
    }

    @Override
    @Transactional
    public Details update(Details details) {
        return entityManager.merge(details);
    }

    @Override
    public void delete(int id) {
        Details details = entityManager.find(Details.class, id);
        if (details != null) entityManager.remove(details);

    }
}
