package com.cvg.reactivas.webflux1.repositiry;

import com.cvg.reactivas.webflux1.models.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepoImpl implements IPersonaRepo {

    private static final Logger log = LoggerFactory.getLogger(PersonaRepoImpl.class);

    @Override
    public Flux<Persona> listar() {
        List<Persona> personas = new ArrayList<>();
        personas.add( new Persona(1, "CRISTHIAN") );
        personas.add( new Persona(2, "ANGELA") );
        personas.add( new Persona(3, "ESMERALDA") );
        return Flux.fromIterable(personas);
    }

    @Override
    public Mono<Persona> listarPoId(Integer id) {
        return Mono.just( new Persona(id, "CRISTHIAN") );
    }

    @Override
    public Mono<Void> eliminar(Integer id) {
        return Mono.empty();
    }

    @Override
    public Mono<Persona> registrar(Persona p) {
        log.info( p.toString() );
        return Mono.just(p);
    }

    @Override
    public Mono<Persona> modificar(Persona p) {
        log.info( p.toString() );
        return Mono.just(p);
    }
}
