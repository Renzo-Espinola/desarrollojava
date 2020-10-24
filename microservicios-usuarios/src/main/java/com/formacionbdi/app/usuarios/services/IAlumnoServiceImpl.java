package com.formacionbdi.app.usuarios.services;
import com.formacionbdi.app.usuarios.models.entity.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.formacionbdi.app.usuarios.models.repository.AlumnoRepository;
import java.util.Optional;


@Service
public class IAlumnoServiceImpl implements IAlumnoService {
   //se inyecta el repositorio
    @Autowired
    private AlumnoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Alumno> findAll() {
        return repository.findAll();
    }

    @Override
    //solo permite la lectura
    @Transactional(readOnly = true)
    public Optional<Alumno> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    //permite la escritura y lectura
    @Transactional
    public Alumno save(Alumno alumno) {
        return repository.save(alumno);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {repository.deleteById(id);
    }
}
