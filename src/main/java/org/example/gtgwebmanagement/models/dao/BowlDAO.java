package org.example.gtgwebmanagement.models.dao;

import org.example.gtgwebmanagement.models.entity.Bowl;

public interface BowlDAO {
    void save(Bowl bowl);

    Bowl findById(long id);

    Bowl[] findAll();

    void update(Bowl bowl);

    void delete(long id);

    void deleteAll();
}