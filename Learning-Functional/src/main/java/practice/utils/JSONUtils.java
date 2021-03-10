package practice.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class JSONUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJSON(Object object){
        String jsonStr = null;
        try {
            jsonStr = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

    public static <T> T parseObject(String text, Class<T> type) {
        try {
            return objectMapper.readValue(text,type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T parseObject(String text, TypeReference<T> valueTypeRef) {
        try {
            SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            objectMapper.setDateFormat(smt);
            objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            return objectMapper.readValue(text, valueTypeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
