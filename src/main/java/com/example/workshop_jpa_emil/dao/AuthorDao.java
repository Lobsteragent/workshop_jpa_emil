package com.example.workshop_jpa_emil.dao;


import com.example.workshop_jpa_emil.models.Author;

import java.util.Collection;
import java.util.Optional;

public interface AuthorDao {

    Author persist(Author Author);

    Optional<Author> findById(Integer id);

    Collection<Author> findAll();

    Author update(Author Author);

    void remove(Integer id);
}
