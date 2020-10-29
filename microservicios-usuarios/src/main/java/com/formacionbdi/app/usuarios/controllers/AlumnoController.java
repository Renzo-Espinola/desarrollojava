package com.formacionbdi.app.usuarios.controllers;

import com.formacionbdi.app.usuarios.models.entity.Alumno;
import com.formacionbdi.app.usuarios.services.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class AlumnoController {

    @Autowired
    private IAlumnoService service;

    //sin darle una ruta toma la raiz
    //al darle el ? se puede guardar cualquier tipo de contenido(alumno examen hashmap)
    // se construhe un gson de varios objetos anidados
    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    //suministramos la ruta que vamos a buscar por ID (ruta variable)
    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id) {
        Optional<Alumno> o = service.findById(id);
        if (o.isEmpty()) {
            //si esta vacio devuelve not found
           return ResponseEntity.notFound().build();
        }
        //OK 200
        return ResponseEntity.ok(o.get());
    }
    //tambien se ubica en la raiz, el arg. viene del body del request
    //el gson que voy a obtner del body debe ser el mismo que el alumno
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Alumno alumno){
        Alumno alumnodDb=service.save(alumno);
    return  ResponseEntity.status(HttpStatus.CREATED).body(alumnodDb);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Alumno alumno,@PathVariable Long id){
        Optional<Alumno> o = service.findById(id);
        if (o.isEmpty()) {
            //si esta vacio devuelve not found
            //NOT FOUND 404
            return ResponseEntity.notFound().build();
        }
        Alumno alumnoDb = o.get();
        alumnoDb.setNombre(alumno.getNombre());
        alumnoDb.setApellido(alumno.getApellido());
        alumnoDb.setEmail(alumno.getEmail());
        //debemos persistir guardar el alumnoDb
        //CREATED 201
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        service.deleteById(id);
        //NON CONTENT 204
       return ResponseEntity.noContent().build();
    }

}

