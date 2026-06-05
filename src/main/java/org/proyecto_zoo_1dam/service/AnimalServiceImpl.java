package org.proyecto_zoo_1dam.service;

import org.proyecto_zoo_1dam.dao.AnimalDao;
import org.proyecto_zoo_1dam.dao.AnimalDaoImpl;
import org.proyecto_zoo_1dam.model.Animal;

import java.util.List;
import java.util.Optional;

public class AnimalServiceImpl implements AnimalService {

    private final AnimalDao dao = new AnimalDaoImpl();

    public Animal create(Animal a) {
        validar(a);
        return dao.insert(a);
    }

    public boolean update(Animal a) {
        validar(a);
        return dao.update(a);
    }

    public boolean delete(int id) {
        return dao.delete(id);
    }

    public Optional<Animal> findById(int id) {
        return dao.findById(id);
    }

    public List<Animal> findAll() {
        return dao.findAll();
    }


    private void validar(Animal a) {
        if (a.getNombre() == null || a.getNombre().isBlank()) {
            throw new IllegalArgumentException("Nombre requerido");
        }
        if (a.getFechaIngreso() == null) {
            throw new IllegalArgumentException("Fecha requerida");
        }
        if (a.getPesoKg() <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor que 0");
        }
    }
}