package com.studentapp.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@DisplayName("Creating Students with String Payload")
public class CreateStudentStringPayloadTest extends TestBase {

    @Link("https://stackoverflow.com/questions/6178583/maven-does-not-find-junit-tests-to-run")
    @DisplayName("Create Student using Payload with String")
    @Description("Description Test with some words.")
    @Test
    void createNewStudent() {

        String payload = "{\"firstName\":\"Vitor\",\"lastName\":\"Marinheiro\",\"email\":\"vitor.marinheiro23@senectuset.org\",\"programme\":\"Computer Science\",\"courses\":[\"Calculus\",\"Algorithms\",\"Software Development\",\"Ethics\"]}";
        given()
                .contentType(ContentType.JSON)
                .when()
                .body(payload)
                .post()
                .then()
                .statusCode(201);
    }
}
