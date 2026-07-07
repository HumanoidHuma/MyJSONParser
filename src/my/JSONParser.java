package my;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class JSONParser {

    public <T> String parse(T object) {
        if (object == null) {
            return "null";
        }
        if (object instanceof String) {
            return "\"" + object.toString() + "\"";
        }
        if (object instanceof Number) {
            return object.toString();
        }
        return parseObject(object);
    }

    public String parseObject(Object object) {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();

        StringBuilder sb = new StringBuilder();
        sb.append("{");

        int count = 0;
        int size = fields.length;
        for (Field field : fields) {
            String attribute = field.getName();
            String value = parse(getFieldValueWithoutChangingAccessModifier(field, object));

            sb.append("\"").append(attribute).append("\":").append(value);

            if (count < size - 1) {
                sb.append(",");
            }

            count++;
        }
        sb.append("}");

        return sb.toString();
    }

    private Object getFieldValueWithoutChangingAccessModifier(Field field, Object object) {
        Object value = null;
        try {
            if (Modifier.isPublic(field.getModifiers())) {
                value = field.get(object);
            } else {
                field.setAccessible(true);
                value = field.get(object);
                field.setAccessible(false);
            }
        } catch (Exception e) {
            System.out.println("Value extraction error");
            System.out.println(e.getStackTrace());
        }
        return value;
    }

    private void pastTextWithIndent(int indentSize, String text, StringBuilder sb) {
        String[] parts = text.split("\n");

        sb.append(parts[0]);
        for (int index = 1; index < parts.length; index++) {
            for (int i = 0; i < indentSize; i++) {
                sb.append(" ");
            }
            sb.append(parts[index]);
        }
    }
}