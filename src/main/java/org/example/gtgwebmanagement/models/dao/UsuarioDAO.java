package org.example.gtgwebmanagement.models.dao;

import org.example.gtgwebmanagement.models.entity.Usuario;

public interface UsuarioDAO {
    void save(Usuario usuario);

    Usuario findById(long id);
    Usuario findByUsername(String username);

    Usuario[] findAll();

    void update(Usuario usuario);

    void delete(long id);

    void deleteAll();
}
