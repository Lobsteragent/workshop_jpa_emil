package com.example.workshop_jpa_emil.dao;


import com.example.workshop_jpa_emil.models.Author;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Optional;

@Repository
public class AuthorDaoImpl implements AuthorDao {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional
    public Author persist(Author author) {
        entityManager.persist(author);
        return author;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Author> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(Author.class, id));
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Author> findAll() {
        return entityManager.createQuery("select a from Author a").getResultList();
    }

    @Override
    @Transactional
    public Author update(Author author) {
        return entityManager.merge(author);
    }

    @Override
    @Transactional
    public void remove(Integer id) {
        entityManager.remove(entityManager.find(Author.class, id));
    }
}
