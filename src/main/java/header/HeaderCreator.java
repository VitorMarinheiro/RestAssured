package header;

import java.util.HashMap;
import java.util.Map;

public class HeaderCreator {

    private HeaderCreator() {
    }

    public static Map<String, String> headerWithAuthToken() {
        Map<String, String> header = new HashMap<>();
        header.put("x-api-key", "0d46d7f4-b571-4841-9447-8cf00697113a");
        return header;
    }

}
