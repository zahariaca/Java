package com.zahariaca.learnreactivespring.router.v1;

import com.zahariaca.learnreactivespring.handler.v1.ItemsHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static com.zahariaca.learnreactivespring.constants.ItemConstants.ITEM_FUNCTIONAL_END_POINT_V1;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class ItemsRouter {

    @Bean
    public RouterFunction<ServerResponse> itemsRoute(ItemsHandler itemsHandler) {
        return RouterFunctions
                .route(GET(ITEM_FUNCTIONAL_END_POINT_V1).and(accept(APPLICATION_JSON)), itemsHandler::getAllItems)
                .andRoute(GET(ITEM_FUNCTIONAL_END_POINT_V1+"/{id}").and(accept(APPLICATION_JSON)),itemsHandler::getOneItem)
                .andRoute(POST(ITEM_FUNCTIONAL_END_POINT_V1).and(accept(APPLICATION_JSON)), itemsHandler::createItem)
                .andRoute(DELETE(ITEM_FUNCTIONAL_END_POINT_V1+"/{id}").and(accept(APPLICATION_JSON)), itemsHandler::deleteItem)
                .andRoute(PUT(ITEM_FUNCTIONAL_END_POINT_V1+"/{id}").and(accept(APPLICATION_JSON)), itemsHandler::updateItem);
    }
}
