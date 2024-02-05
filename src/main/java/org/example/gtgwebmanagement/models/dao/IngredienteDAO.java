package org.example.gtgwebmanagement.models.dao;


import org.example.gtgwebmanagement.models.entity.Ingrediente;


public interface IngredienteDAO {
    void save(Ingrediente ingrediente);

    Ingrediente findById(long id);

    Ingrediente[] findAll();

    void update(Ingrediente ingrediente);

    void delete(long id);

    void deleteAll();
}
