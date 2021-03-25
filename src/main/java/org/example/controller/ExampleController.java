package org.example.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.retry.annotation.CircuitBreaker;
import io.reactivex.rxjava3.core.Single;

/**
 * @author aveselov
 * @since 25/03/2021
 */
@Controller
@CircuitBreaker
public class ExampleController {

    @Get("/")
    public Single<String> endpoint() {
        return Single.fromSupplier(this::serviceCall);
    }

    private String serviceCall() {
        throw new RuntimeException();
    }
}
