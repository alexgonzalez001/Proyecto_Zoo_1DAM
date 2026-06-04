package org.proyecto_zoo_1dam.model;

import java.time.LocalDate;

public class Animal {

    private Integer id;
    private String nombre;
    private LocalDate fechaIngreso;
    private double pesoKg;

    public Animal(Integer id, String nombre, LocalDate fechaIngreso, double pesoKg) {
        this.id = id;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.pesoKg = pesoKg;
    }

    // constructor para cuando aun no hay id (al crear uno nuevo)
    public Animal(String nombre, LocalDate fechaIngreso, double pesoKg) {
        this(null, nombre, fechaIngreso, pesoKg);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }
}