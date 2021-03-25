package org.example.controller;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientException;
import io.micronaut.rxjava3.http.client.Rx3HttpClient;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author aveselov
 * @since 25/03/2021
 */
@MicronautTest
class ExampleControllerTest {

    @Inject
    @Client("/")
    Rx3HttpClient httpClient;

    @Test
    void example() {
        // fail first; open CircuitBreaker
        assertThrows(HttpClientException.class, () -> httpClient.exchange("/").blockingSingle());

        // fail second, expect fail as CircuitBreaker is opened
        assertThrows(HttpClientException.class, () -> httpClient.exchange("/").blockingSingle());
    }

}