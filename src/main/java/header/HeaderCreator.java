package header;

import constants.GetParameter;

import java.util.HashMap;
import java.util.Map;

public class HeaderCreator {

    private HeaderCreator() {
    }

    public static Map<String, String> headerWithAuthToken() {

        // If you don't want to make use of the AWS Parameter Store, comment out line number 23,
        //uncomment the number 24 and include your API key in the String field.

        //Caso você não queira fazer uso do AWS Parameter Store, comente a linha de número 23,
        //descomente a de número 24 e inclua sua chave de API no campo String.

        Map<String, String> header = new HashMap<>();

        header.put("x-api-key", GetParameter.getApiToken());
        //header.put("x-api-key", "SUA_CHAVE_DE_API_VEM_AQUI");

        return header;
    }

}
