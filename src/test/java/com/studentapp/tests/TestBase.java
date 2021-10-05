package com.studentapp.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    public static void init(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8085;
        RestAssured.basePath = "/student";

        // Caso seja necessário, podemos utilizar o método RestAssured.reset() dentro dos testes para resetar esses valores
    }
}
