package co.com.sofka.api;

import co.com.sofka.model.galletas.Galleta;
import co.com.sofka.usecase.galletas.GalletasUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

    private final GalletasUseCase useCase;

    public Mono<ServerResponse> listenPostUseCase(ServerRequest serverRequest) {

        return serverRequest.bodyToMono(Galleta.class)
                .flatMap(galleta -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(useCase.createGalleta(galleta), Galleta.class));

    }

    public Mono<ServerResponse> listenGetUseCase(ServerRequest serverRequest) {

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(useCase.findAll(), Galleta.class);

    }

    public Mono<ServerResponse> listenGetUseCaseById(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("idgalleta");
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(useCase.findById(id), Galleta.class);

    }


    public Mono<ServerResponse> listenGetUseCaseAllPar(ServerRequest serverRequest) {

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(useCase.findGalletaPar(), Galleta.class);

    }

    public Mono<ServerResponse> listenGetUseCaseAllString(ServerRequest serverRequest) {

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(useCase.findAllString(), Galleta.class);

    }

}
