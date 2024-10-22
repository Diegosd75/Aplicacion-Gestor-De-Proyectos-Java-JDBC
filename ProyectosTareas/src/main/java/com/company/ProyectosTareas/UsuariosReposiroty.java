package com.company.ProyectosTareas;

import org.springframework.data.repository.CrudRepository;

public interface UsuariosReposiroty extends CrudRepository<Usuarios,Long>  {
    Usuarios findByUsuario(String usuario);
}
