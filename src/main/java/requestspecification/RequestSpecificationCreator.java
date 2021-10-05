package requestspecification;

import constants.ProjectConstants;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationCreator {

    public static RequestSpecification requestSpecification(){
        return new RequestSpecBuilder().setBaseUri(ProjectConstants.URI+ProjectConstants.VERSION).build();
    }

}
