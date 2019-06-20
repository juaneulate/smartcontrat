package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtil<T> {

    private static Gson gson= new Gson();

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

    public static <T>T fromJson(String serializable, TypeToken type){
        return gson.fromJson(serializable,type.getType());

    }

}
