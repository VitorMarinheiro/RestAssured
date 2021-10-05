package testcases;

import constants.ProjectConstants;
import header.HeaderCreator;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import requestspecification.RequestSpecificationCreator;
import static io.restassured.RestAssured.given;

@Severity(SeverityLevel.BLOCKER)
@DisplayName("Health Check's")
class HealthCheckTest {

    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Health Check API")
    @Test
    void healthCheck(){

        given()
                .spec(RequestSpecificationCreator.requestSpecification())
                .headers(HeaderCreator.headerWithAuthToken())
        .when()
                .get(ProjectConstants.URI_VOTES)
        .then()
                .statusCode(200);

    }

    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Health Check Auth")
    @Test
    void healthCheck_NoAuth(){

        given()
                .spec(RequestSpecificationCreator.requestSpecification())
        .when()
                .get(ProjectConstants.URI_VOTES)
        .then()
                .statusCode(401);

    }

}
