package my;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONParser {

    private static Map<Class<?>, Field[]> classMap = new HashMap<>();

    public <T> String parse(T object) throws IllegalAccessException {
        if (object == null) {
            return parseNull(object);
        }
        if (object instanceof String) {
            return parseString(object);
        }
        if (object instanceof Number) {
            return parseInteger(object);
        }
        if (object instanceof JsonObject) {
            return parseToJson((JsonObject) object);
        }
        return parse(extractJsonObject(object));
    }

    public String parseToJson(JsonObject jsonObject) {
        StringBuilder json = new StringBuilder();

        List<JsonField> fields = jsonObject.getFields();
        int size = fields.size();

        json.append("{");
        int count = 0;
        for (JsonField field : fields) {
            json.append("\"").append(field.getField()).append("\"");
            json.append(":");
            json.append(field.getValue());
            if (count < size - 1) {
                json.append(",");
            }
            count++;
        }
        json.append("}");

        return json.toString();
    }

    public JsonObject extractJsonObject(Object object) throws IllegalAccessException {
        JsonObject jsonObject = new JsonObject();

        Class<?> clazz = object.getClass();
        classMap.computeIfAbsent(clazz, objectClass -> objectClass.getDeclaredFields());
        Field[] fields = classMap.get(clazz);

        for (Field field : fields) {
            String fieldValue = "null";
            if (field.trySetAccessible()) {
                fieldValue = parse(field.get(object));
            }
            jsonObject.putField(field.getName(), fieldValue);
        }

        return jsonObject;
    }

    public String parseString(Object object) {
        return "\"" + object.toString() + "\"";
    }

    public String parseNull(Object object) {
        return "NULL";
    }

    public String parseInteger(Object object) {
        return object.toString();
    }

    public static Map<Class<?>, Field[]> getHashedClass() {
        return classMap;
    }
}