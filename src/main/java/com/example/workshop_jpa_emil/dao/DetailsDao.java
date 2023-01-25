package com.example.workshop_jpa_emil.dao;

import com.example.workshop_jpa_emil.models.Details;

import java.util.Collection;
import java.util.Optional;

public interface DetailsDao {

    Details persist(Details details);
    Optional findById(int id);
    Collection findAll();
    Details update(Details details);
    void delete (int id);

}
