package com.studentapp.tests;

import com.github.javafaker.Faker;
import com.studentapp.model.StudentPOJO;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UpdateStudentObjectPayloadTest extends TestBase {

    @DisplayName("Update Student using PUT and Payload with Object")
    @Test
    void updateStudentUsingPUT() {

        Faker fake = new Faker();
        List<String> courses = new ArrayList<String>();
        courses.add("Anatomy");
        courses.add("Biochemistry");
        courses.add("Genetics");

        StudentPOJO student = new StudentPOJO();
        student.setFirstName(fake.name().firstName());
        student.setLastName(fake.name().lastName());
        student.setEmail(fake.internet().emailAddress());
        student.setProgramme("Medicine");
        student.setCourses(courses);

        given()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .put("/40")
                .then()
                .statusCode(200);
    }

    @DisplayName("Update Student using PATCH and Payload with Object")
    @Test
    void updateStudentUsingPATCH() {

        Faker fake = new Faker();
        StudentPOJO student = new StudentPOJO();

        student.setEmail(fake.internet().emailAddress());
        System.out.println(student.getEmail());
        given()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .patch("/50")
                .then()
                .statusCode(200);
    }
}
