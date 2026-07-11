package my;

import my.Entities.*;
import my.Entities.EntitiesInterface.*;
import my.Formatters.Compressed.CompressedFormat;
import my.FormattersInterface.Formatter;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class JSONParser {
    private static final Map<Class<?>, Field[]> hashedClasses = new LinkedHashMap<>();

    private Formatter formatter = new CompressedFormat();

    public <T> String serialize(T object) {
        JsonValue jsonObject = parseToJsonObject(object);
        return formatter.formate(jsonObject);
    }

    public <T> JsonValue parseToJsonObject(T object) {
        if (object == null) {
            return JsonNull.getInstance();
        }
        if (object instanceof String) {
            return parseString((String) object);
        }
        if (object instanceof Number) {
            return parseNumber((Number) object);
        }
        if (object instanceof JsonValue) {
            return (JsonValue) object;
        }
        return extractJsonObject(object);
    }

    public JsonObject extractJsonObject(Object object) {
        Class<?> clazz = object.getClass();
        if (!JSONParser.hashedClasses.containsKey(clazz)) {
            hashClass(clazz);
        }
        Field[] fields = hashedClasses.get(clazz);

        JsonObject json = new JsonObject();

        try {
            for (Field field : fields) {
                JsonString jsonFieldKey = (JsonString) parseToJsonObject(field.getName());
                JsonValue jsonValue = parseToJsonObject(field.get(object));

                JsonField jsonField = new JsonField(jsonFieldKey, jsonValue);
                json.addField(jsonField);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Field can not be parsed to Json Object");
        }

        return json;
    }

    public JsonString parseString(String object) {
        return new JsonString(object);
    }

    public JsonNumber parseNumber(Number object) {
        return new JsonNumber(object);
    }

    private Field[] hashClass(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.trySetAccessible();
        }
        hashedClasses.put(clazz, fields);
        return fields;
    }

    public static Set<Class<?>> getHashedClass() {
        return hashedClasses.keySet();
    }
}