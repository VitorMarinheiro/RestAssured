package header;

import constants.GetParameter;

import java.util.HashMap;
import java.util.Map;

public class HeaderCreator {

    private HeaderCreator() {
    }

    public static Map<String, String> headerWithAuthToken() {
        Map<String, String> header = new HashMap<>();

//      Caso você não queira fazer uso do AWS Parameter Store, comente a linha de número 19,
//      descomente a de número 20 e inclua sua chave de API no campo String.

        header.put("x-api-key", GetParameter.getApiToken());
        //header.put("x-api-key", "SUA_CHAVE_DE_API_VEM_AQUI");

        return header;
    }

}
