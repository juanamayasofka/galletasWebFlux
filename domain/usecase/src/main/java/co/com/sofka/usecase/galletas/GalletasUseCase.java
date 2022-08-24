package co.com.sofka.usecase.galletas;

import co.com.sofka.model.galletas.Galleta;
import co.com.sofka.model.galletas.gateways.GalletasRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GalletasUseCase {

    private final GalletasRepository repository;

    public Mono<Galleta> createGalleta(Galleta galleta){
        return repository.save(galleta);
    }

    public Mono<Galleta> findById(String idGalleta){
        return repository.findById(idGalleta)
                .filter(galleta -> galleta.getId().length() > 0)
                .map(galleta -> galleta)
                .defaultIfEmpty(Galleta.builder().id("0").name("Galleta no encontrada").build());
    }

    public Flux<Galleta> findAll(){
        return repository.findAll();
    }

    public Flux<Galleta> findGalletaPar(){
        return repository.findAll()
                .filter(galleta -> Integer.parseInt(galleta.getId())/2 ==0)
                .switchIfEmpty(monoError());
    }

    public Mono<Galleta> monoError(){
        return Mono.just(Galleta.builder().id("0").name("Error en la busqueda").build());
    }

    public Mono<String> findAllString(){
        return repository.findAll()
                .map(galleta -> galleta.getName())
                .reduce((subtotal, str) -> subtotal.concat(" - ").concat(str));
    }
}
