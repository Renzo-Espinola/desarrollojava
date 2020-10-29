package com.formacionbdi.app.usuarios.services;

import com.formacionbdi.app.usuarios.models.entity.Alumno;

import java.util.Optional;

public interface IAlumnoService {

    public Iterable<Alumno> findAll();

    public Optional<Alumno> findById(String id);

    public Alumno save (Alumno alumno);

    public void deleteById (Long id);

}
