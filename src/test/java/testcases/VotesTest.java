package testcases;

import com.github.javafaker.Faker;
import constants.ProjectConstants;
import header.HeaderCreator;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojomodels.VotePojo;
import requestspecification.RequestSpecificationCreator;

import static io.restassured.RestAssured.given;

@DisplayName("Tests from Vote API")
public class VotesTest {

    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Get All Votes")
    @Test
    public void getAllVotes(){

        given()
                .spec(RequestSpecificationCreator.requestSpecification())
                .headers(HeaderCreator.headerWithAuthToken())
        .when()
                .get(ProjectConstants.URI_VOTES)
        .then()
                .statusCode(200);
    }

    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Validating a Entire Element")
    @Test
    public void getASpecificVote(){


        given()
                .spec(RequestSpecificationCreator.requestSpecification())
                .headers(HeaderCreator.headerWithAuthToken())
                .pathParam("id", 332347)
        .when()
                .get(ProjectConstants.URI_VOTES+"/{id}")
        .then()
                .assertThat()
                .body(Matchers.equalTo("{\"id\":332347,\"user_id\":\"w1lfkm\",\"image_id\":\"asf4\",\"sub_id\":\"my-user-1234\",\"created_at\":\"2021-10-05T15:55:12.000Z\",\"value\":1,\"country_code\":\"BR\"}"));

    }

    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Validating A Single Field")
    @Test
    public void validateASingleField(){

        given()
                .spec(RequestSpecificationCreator.requestSpecification())
                .headers(HeaderCreator.headerWithAuthToken())
                .pathParam("id", 332347)
        .when()
                .get(ProjectConstants.URI_VOTES+"/{id}")
        .then()
                .assertThat()
                .body("country_code", Is.is("BR")).log().body();
    }

    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Creating A Vote With POJO")
    @Test
    public void postVoteWithPojo(){

        VotePojo vote = new VotePojo();
        vote.setImage_id(new Faker().name().firstName());
        vote.setSub_id("my-user-1234");
        vote.setValue(1);

        given()
                .spec(RequestSpecificationCreator.requestSpecification())
                .headers(HeaderCreator.headerWithAuthToken())
                .contentType(ContentType.JSON)
        .when()
                .body(vote)
                .post(ProjectConstants.URI_VOTES)
        .then()
                .statusCode(200).log().body();
    }

    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Creating A Vote With String")
    @Test
    public void postVoteWithString(){

        String payload = "{\"image_id\":\""+new Faker().name().firstName()+"\",\"sub_id\":\"my-user-1234\",\"value\":1}";

        given()
                .spec(RequestSpecificationCreator.requestSpecification())
                .headers(HeaderCreator.headerWithAuthToken())
                .contentType(ContentType.JSON)
        .when()
                .body(payload)
                .post(ProjectConstants.URI_VOTES)
        .then()
                .statusCode(200).log().body();
    }

    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Deleting a Specific Vote")
    @Test
    public void deleteAVote(){
        given()
                .spec(RequestSpecificationCreator.requestSpecification())
                .headers(HeaderCreator.headerWithAuthToken())
                .pathParam("id", 332393)
        .when()
                .delete(ProjectConstants.URI_VOTES+"/{id}")
        .then()
                .statusCode(200);
    }

}
