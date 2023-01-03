package com.gmail.at.kotamadeo.integration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Testcontainers
public class BaseIT {
    private static final String PROD_CONTAINER_NAME = "netology-homework-testcontainers-prod";
    private static final String DEV_CONTAINER_NAME = "netology-homework-testcontainers-dev";
    protected static final int PROD_PORT = 8081;
    protected static final int DEV_PORT = 8080;
    @Container
    protected static final GenericContainer<?> PROD_CONTAINER = new GenericContainer<>(PROD_CONTAINER_NAME)
            .withExposedPorts(PROD_PORT);
    @Container
    protected static final GenericContainer<?> DEV_CONTAINER = new GenericContainer<>(DEV_CONTAINER_NAME)
            .withExposedPorts(DEV_PORT);
}
