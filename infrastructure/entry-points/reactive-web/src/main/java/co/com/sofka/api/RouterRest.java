package co.com.sofka.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class RouterRest {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(Handler handler) {
        return route(GET("/api/usecase/galleta"), handler::listenGetUseCase)
                .andRoute(POST("/api/usecase/galleta"), handler::listenPostUseCase)
                .andRoute(GET("api/usecase/galleta/{idgalleta}"), handler::listenGetUseCaseById)
                .andRoute(GET("api/usecase/galletastring"), handler::listenGetUseCaseAllString)
                .andRoute(GET("api/usecase/galletapar"), handler::listenGetUseCaseAllPar);

    }
}
