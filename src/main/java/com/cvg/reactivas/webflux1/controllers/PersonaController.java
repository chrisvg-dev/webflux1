package com.cvg.reactivas.webflux1.controllers;

import com.cvg.reactivas.webflux1.models.Persona;
import com.cvg.reactivas.webflux1.repositiry.IPersonaRepo;
import com.cvg.reactivas.webflux1.repositiry.PersonaRepoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    private static final Logger log = LoggerFactory.getLogger(PersonaController.class);

    @Autowired
    private IPersonaRepo repo;

    @GetMapping
    public Flux<Persona> listar(){
        return repo.listar();
    }

    @GetMapping("/{id}")
    public Mono<Persona> listarPorId(@PathVariable Integer id){
        return repo.listarPoId(id);
    }

    @DeleteMapping ("/del/{id}")
    public ResponseEntity<Mono<Void>> eliminar(@PathVariable Integer id){
        return new ResponseEntity(
                repo.listarPoId(id).flatMap( p -> repo.eliminar(id) ),
                HttpStatus.NO_CONTENT
        );
    }

    @PostMapping
    public Mono<Persona> registrar(@RequestBody Persona persona) {
        return repo.registrar(persona);
    }

    @PutMapping
    public Mono<Persona> modificar(@RequestBody Persona persona) {
        return repo.registrar(persona);
    }
}
