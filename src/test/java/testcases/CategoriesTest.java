package testcases;

import constants.ProjectConstants;
import header.HeaderCreator;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import requestspecification.RequestSpecificationCreator;

import static io.restassured.RestAssured.given;

@DisplayName("Tests from Categories API")
public class CategoriesTest {

    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Validate All Categories Size")
    @Test
    public void validateAllCategoriesSize() {

        given()
                .spec(RequestSpecificationCreator.requestSpecification())
                .headers(HeaderCreator.headerWithAuthToken())
        .when()
                .get(ProjectConstants.URI_CATEGORIES)
        .then()
                .statusCode(200)
                .assertThat()
                .body("size()", Is.is(7));
    }

    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Get Categories by Id")
    @Test
    public void getCategoriesById() {

        given()
                .spec(RequestSpecificationCreator.requestSpecification())
                .headers(HeaderCreator.headerWithAuthToken())
                .pathParam("id", 5)
        .when()
                .get(ProjectConstants.URI_CATEGORIES+"/{id}")
        .then()
                .statusCode(200)
                .assertThat()
                .body("name", Is.is("boxes"));
    }

}
