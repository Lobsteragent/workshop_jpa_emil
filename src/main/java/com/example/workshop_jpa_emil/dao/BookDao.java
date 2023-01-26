package com.example.workshop_jpa_emil.dao;

import com.example.workshop_jpa_emil.models.Book;

import java.util.Collection;
import java.util.Optional;

public interface BookDao {

        Book persist(Book book);

        Optional<Book> findById(Integer id);

        Collection<Book> findAll();

        Book update(Book book);

        void remove(Integer id);
    }
