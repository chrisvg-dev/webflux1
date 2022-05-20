package com.cvg.reactivas.webflux1.repositiry;

import com.cvg.reactivas.webflux1.models.Persona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonaRepo {
    Flux<Persona> listar();
    Mono<Persona> listarPoId(Integer id);
    Mono<Void> eliminar(Integer id);
    Mono<Persona> registrar(Persona p);
    Mono<Persona> modificar(Persona p);
}
