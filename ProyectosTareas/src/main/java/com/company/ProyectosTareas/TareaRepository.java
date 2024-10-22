package com.company.ProyectosTareas;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TareaRepository extends CrudRepository<Tarea,Long> {

    List<Tarea> findByTarea(String tarea);

    Proyecto findById(long id);

}
