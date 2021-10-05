package testcases;

import constants.ProjectConstants;
import header.HeaderCreator;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import requestspecification.RequestSpecificationCreator;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@DisplayName("Tests from Breeds API")
public class BreedsTest {

    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Get All Breeds")
    @Test
    public void getAllBreeds() {

        given()
                .spec(RequestSpecificationCreator.requestSpecification())
                .headers(HeaderCreator.headerWithAuthToken())
        .when()
                .get(ProjectConstants.URI_BREEDS)
        .then()
                .statusCode(200).log().body();
    }

    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Get Breeds by Name")
    @Test
    public void getBreedByName() {

        given()
                .spec(RequestSpecificationCreator.requestSpecification())
                .headers(HeaderCreator.headerWithAuthToken())
        .when()
                .queryParam("q", "aby")
                .get(ProjectConstants.URI_BREEDS_SEARCH)
        .then()
                .assertThat()
                .body(containsString("Abyssinian"))
                .statusCode(200).log().body();
    }
}