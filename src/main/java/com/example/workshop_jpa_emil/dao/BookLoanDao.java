package com.example.workshop_jpa_emil.dao;

import com.example.workshop_jpa_emil.models.BookLoan;

import java.util.Collection;
import java.util.Optional;

public interface BookLoanDao {

    BookLoan persist(BookLoan bookLoan);

    Optional<BookLoan> findById(Integer id);

    Collection<BookLoan> findAll();

    BookLoan update(BookLoan bookLoan);

    void remove(Integer id);
}
