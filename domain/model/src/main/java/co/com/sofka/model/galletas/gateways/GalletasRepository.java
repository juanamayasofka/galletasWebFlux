package co.com.sofka.model.galletas.gateways;

import co.com.sofka.model.galletas.Galleta;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GalletasRepository {

    Mono<Galleta> save(Galleta galleta);

    Flux<Galleta> findAll();

    Mono<Galleta> findById(String id);


}
