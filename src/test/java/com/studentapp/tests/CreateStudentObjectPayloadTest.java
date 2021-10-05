//package com.studentapp.tests;
//
//import com.github.javafaker.Faker;
//import pojomodels.VotePojo;
//import io.restassured.http.ContentType;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static io.restassured.RestAssured.given;
//
//public class CreateStudentObjectPayloadTest extends TestBase {
//
//    @DisplayName("Create Student using Payload with Object")
//    @Test
//    void updateStudentUsingPUT() {
//
//        Faker fake = new Faker();
//        List<String> courses = new ArrayList<String>();
//        courses.add("Anatomy");
//        courses.add("Biochemistry");
//        courses.add("Genetics");
//
//
//        given()
//                .contentType(ContentType.JSON)
//                .when()
//                .body(student)
//                .post()
//                .then()
//                .statusCode(201);
//    }
//}
