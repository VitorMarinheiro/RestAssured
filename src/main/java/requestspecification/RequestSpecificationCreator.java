package requestspecification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationCreator {

    public static RequestSpecification requestSpecification(){
        return new RequestSpecBuilder().setBaseUri("https://api.thecatapi.com/v1").build();
    }

}
