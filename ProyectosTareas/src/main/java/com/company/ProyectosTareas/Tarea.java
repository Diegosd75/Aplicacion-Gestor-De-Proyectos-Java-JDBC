package com.company.ProyectosTareas;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tarea {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String tarea;
    private String descripcion;

    protected Tarea(){}

    public Tarea( String tarea, String descripcion) {
        this.tarea = tarea;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", tarea='" + tarea + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getTarea() {
        return tarea;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
