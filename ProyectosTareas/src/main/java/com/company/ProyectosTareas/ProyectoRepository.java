package com.company.ProyectosTareas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProyectoRepository extends JpaRepository<Proyecto,Long> {

    List<Proyecto> findByProyecto(String proyecto);

    Proyecto getProyectoById(long id);

    List<Proyecto> findAll();



}
