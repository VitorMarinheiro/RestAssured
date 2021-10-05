package header;

import java.util.HashMap;
import java.util.Map;

public class HeaderCreator {

    public static Map<String, String> headerWithAuthToken() {
        Map<String, String> Header = new HashMap<>();
        Header.put("x-api-key", "0d46d7f4-b571-4841-9447-8cf00697113a");
        return Header;
    }

}
