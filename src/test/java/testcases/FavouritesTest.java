package testcases;

import com.github.javafaker.Faker;
import constants.ProjectConstants;
import header.HeaderCreator;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojomodels.FavouritePojo;
import requestspecification.RequestSpecificationCreator;

import static io.restassured.RestAssured.given;

public class FavouritesTest {

    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Get all Favourites")
    @Test
    public void getAllFavourites() {

        given()
                .spec(RequestSpecificationCreator.requestSpecification())
                .headers(HeaderCreator.headerWithAuthToken())
        .when()
                .get(ProjectConstants.URI_FAVOURITES)
        .then()
                .statusCode(200);
    }

    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Get a Favourite by Id")
    @Test
    public void getFavouriteById() {

        given()
                .spec(RequestSpecificationCreator.requestSpecification())
                .headers(HeaderCreator.headerWithAuthToken())
                .pathParam("id", 2105627)
        .when()
                .get(ProjectConstants.URI_FAVOURITES+"/{id}")
        .then()
                .statusCode(200)
                .assertThat()
                .body("id", Is.is(2105627)).log().body();
    }

    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Creating a New Favourite")
    @Test
    public void createANewFavourite() {

        FavouritePojo favourite = new FavouritePojo();
        favourite.setImage_id(new Faker().number().digits(8));
        favourite.setSub_id(new Faker().name().name());

        given()
                .spec(RequestSpecificationCreator.requestSpecification())
                .headers(HeaderCreator.headerWithAuthToken())
                .contentType(ContentType.JSON)
        .when()
                .body(favourite)
                .post(ProjectConstants.URI_FAVOURITES)
        .then()
                .statusCode(200).log().body();
    }

    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Creating a Repeat Favourite")
    @Test
    public void createARepeatFavourite() {

        String imageName = new Faker().number().digits(8);
        String imageId = new Faker().name().name();

        FavouritePojo favourite = new FavouritePojo();
        favourite.setImage_id(imageName);
        favourite.setSub_id(imageId);

        // Firts post
        given()
                .spec(RequestSpecificationCreator.requestSpecification())
                .headers(HeaderCreator.headerWithAuthToken())
                .contentType(ContentType.JSON)
        .when()
                .body(favourite)
                .post(ProjectConstants.URI_FAVOURITES)
        .then()
                .statusCode(200).log().body();

        // Second Post
        given()
                .spec(RequestSpecificationCreator.requestSpecification())
                .headers(HeaderCreator.headerWithAuthToken())
                .contentType(ContentType.JSON)
        .when()
                .body(favourite)
                .post(ProjectConstants.URI_FAVOURITES)
        .then()
                .statusCode(400)
                .assertThat()
                .body("message", Is.is("DUPLICATE_FAVOURITE - favourites are unique for account + image_id + sub_id"))
                .log().body();
    }

    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Deleting a Favourite")
    @Test
    public void deletingAFavourite() {

        FavouritePojo favourite = new FavouritePojo();
        favourite.setImage_id(new Faker().number().digits(8));
        favourite.setSub_id(new Faker().name().name());

        Integer id = given()
                .spec(RequestSpecificationCreator.requestSpecification())
                .headers(HeaderCreator.headerWithAuthToken())
                .contentType(ContentType.JSON)
        .when()
                .body(favourite)
                .post(ProjectConstants.URI_FAVOURITES)
                .then().extract().response().body().path("id");

        // Deleting
        given()
                .spec(RequestSpecificationCreator.requestSpecification())
                .headers(HeaderCreator.headerWithAuthToken())
                .pathParam("id", id)
        .when()
                .delete(ProjectConstants.URI_FAVOURITES+"/{id}")
        .then()
                .statusCode(200).log().body();
    }

    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Deleting a non-existent Favourite")
    @Test
    public void deletingANonExistentFavourite() {

        given()
                .spec(RequestSpecificationCreator.requestSpecification())
                .headers(HeaderCreator.headerWithAuthToken())
                .pathParam("id", 1)
        .when()
                .delete(ProjectConstants.URI_FAVOURITES+"/{id}")
        .then()
                .statusCode(400)
                .assertThat()
                .body("message", Is.is("INVALID_ACCOUNT"))
                .log().body();
    }

}
