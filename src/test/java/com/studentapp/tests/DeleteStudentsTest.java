package com.studentapp.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteStudentsTest extends TestBase{

    @DisplayName("Delete a Students")
    @Test
    void deleteAStudent() {
        given()
                .when()
                .delete("/99")
                .then()
                .statusCode(204);
    }

}
