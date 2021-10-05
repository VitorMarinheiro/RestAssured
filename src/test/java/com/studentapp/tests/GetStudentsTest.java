package com.studentapp.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;

public class GetStudentsTest extends TestBase{

    @DisplayName("Getting all the Students")
    @Test
    void getAllStudents() {
        given()
                .when()
                .get("/list")
                .then()
                .statusCode(200);
    }

    @DisplayName("Getting all the Medicine Students")
    @Test
    void getAllMedicineStudents() {
        given()
                .queryParam("programme", "Medicine")
                .when()
                .get("/list").prettyPrint();
    }

    @DisplayName("Getting Student by Id")
    @Test
    void getStudentById() {
        given()
                .pathParam("id", 2)
                .when()
                .get("/{id}").prettyPrint();
    }

    @DisplayName("Getting a single Medicine Student")
    @Test
    void getASingleMedicineStudent() {

        // Podemos passar vários parametros via HASH
        Map<String, Object> params = new HashMap<>();
        params.put("programme", "Medicine");
        params.put("limit", 1);


        given()
//                // Passando os parametros na mesma linha
//                .queryParams("programme", "Medicine", "limit", 1)
//
//                // Passando um parametro por vez
//                .queryParam("programme", "Medicine")
//                .queryParam("limit", 1)

                // Passando via HASH
                .queryParams(params)
                .when()
                .get("/list").prettyPrint();
    }
}
