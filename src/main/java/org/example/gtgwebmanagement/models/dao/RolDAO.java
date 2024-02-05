package org.example.gtgwebmanagement.models.dao;


import org.example.gtgwebmanagement.models.entity.Rol;


public interface RolDAO {
    void save(Rol rol);

    Rol findById(long id);

    Rol[] findAll();

    void update(Rol rol);

    void delete(long id);

    void deleteAll();
}
