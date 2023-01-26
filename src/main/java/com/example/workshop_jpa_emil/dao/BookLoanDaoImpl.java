package com.example.workshop_jpa_emil.dao;

import com.example.workshop_jpa_emil.models.BookLoan;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Optional;


public class BookLoanDaoImpl implements BookLoanDao{
    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional
    public BookLoan persist(BookLoan bookLoan) {
        entityManager.persist(bookLoan);
        return bookLoan;
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<BookLoan> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(BookLoan.class, id));
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<BookLoan> findAll() {
        return entityManager.createQuery("select b from BookLoan b").getResultList();
    }

    @Override
    @Transactional
    public BookLoan update(BookLoan bookLoan) {
        return entityManager.merge(bookLoan);
    }

    @Override
    @Transactional
    public void remove(Integer id) {
        entityManager.remove(entityManager.find(BookLoan.class, id));
    }
}
