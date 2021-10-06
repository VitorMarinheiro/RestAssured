package header;

import constants.GetParameter;

import java.util.HashMap;
import java.util.Map;

public class HeaderCreator {

    private HeaderCreator() {
    }

    public static Map<String, String> headerWithAuthToken() {
        Map<String, String> header = new HashMap<>();
        header.put("x-api-key", GetParameter.getApiToken());
        return header;
    }

}
