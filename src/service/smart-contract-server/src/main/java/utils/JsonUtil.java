package utils;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtil {

    public static String toJson(Object object) {
        String jsonObject = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            jsonObject = objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}
