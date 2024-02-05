package org.example.gtgwebmanagement.models.dao;

import org.example.gtgwebmanagement.models.entity.Menu;

public interface MenuDAO {
    void save(Menu menu);

    Menu findById(long id);

    Menu[] findAll();

    void update(Menu menu);

    void delete(long id);

    void deleteAll();
}
