package com.studentapp.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.*;
import com.jayway.jsonpath.JsonPath;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonPathJayWay {

    static String jsonResponse;

    static void print(String v1) {
        System.out.println("---------------");
        System.out.println(v1);
        System.out.println("---------------");
    }

    @BeforeAll
    public static void initialize() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;

        jsonResponse = RestAssured.given().when().get("/products").asString();
    }

    @BeforeEach
    void printToConsole() {
        System.out.println("-- Starting Test Method --");
        System.out.println(" ");
    }

    @AfterEach
    void printToConsoleAgain() {
        System.out.println("-- Ending Test Method --");
        System.out.println(" ");
    }

    @DisplayName("Get the root element")
    @Test
    public void getRoot() {
        Map<String, ?> rootElement = JsonPath.read(jsonResponse, "$");
        print(rootElement.toString());
    }

    @DisplayName("Get the total value from the response")
    @Test
    public void getTotalFromResponse(){
        int totalValue = JsonPath.read(jsonResponse, "$.total");
        print(totalValue + "");
    }


    @DisplayName("Get all the data elements")
    @Test
    public void getAllDataElements(){
        List<HashMap<String,Object>> dataElements= JsonPath.read(jsonResponse, "$.data");
        dataElements.stream().forEach(System.out::println);
    }

    @DisplayName("Get firstDataElement")
    @Test
    public void getFirstDataElement(){
        Map<String,?> firstDataElement = JsonPath.read(jsonResponse, "$.data[0]");
        print(firstDataElement.toString());
    }

    @DisplayName("Get lastDataElement")
    @Test
    public void getLastDataElement(){
        Map<String,?> lastDataElement = JsonPath.read(jsonResponse, "$.data[-1]");
        print(lastDataElement.toString());
    }

    @DisplayName("Get all the ids in data")
    @Test
    public void getAllIdsUnderData(){
        List<String> lastDataElement = JsonPath.read(jsonResponse, "$.data[*].id");
        print(lastDataElement.toString());
    }


    @DisplayName("Get All the Ids")
    @Test
    public void getAllIds(){
        List<String> allIds = JsonPath.read(jsonResponse, "$..[*].id");
        print(allIds.toString());
    }

    @DisplayName("Get The name of the products whose price is less than 5")
    @Test
    public void getNameOfProductsWhosePriceisLessThan5(){
        List<String> names = JsonPath.read(jsonResponse, "$.data[?(@.price>5)].name");
        names.stream().forEach(System.out::println);
    }


}
