package constants;

import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagement;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagementClientBuilder;
import com.amazonaws.services.simplesystemsmanagement.model.GetParameterResult;

public class GetParameter {

    private GetParameter() {
    }

    static final AWSSimpleSystemsManagement client = AWSSimpleSystemsManagementClientBuilder.defaultClient();

    public static String getApiToken() {

        AWSSimpleSystemsManagement awsSimpleSystemsManagement;
        awsSimpleSystemsManagement = client;

        com.amazonaws.services.simplesystemsmanagement.model.GetParameterRequest request = new com.amazonaws.services.simplesystemsmanagement.model.GetParameterRequest();
        request.withName(ProjectConstants.API_TOKEN_PARAMETER).withWithDecryption(true);
        GetParameterResult result = awsSimpleSystemsManagement.getParameter(request);

        return result.getParameter().getValue();
    }

}