package my.Formatters.Compressed;

import my.Entities.*;
import my.Entities.EntitiesInterface.*;
import my.FormattersInterface.Formatter;
import my.FormattersInterface.JsonFieldFormatter;
import my.FormattersInterface.JsonObjectFormatter;

public class CompressedFormat implements Formatter {
    @Override
    public String formate(JsonValue object) {
        if (object instanceof JsonNull) {
            return "null";
        }
        if (object instanceof JsonString) {
            return parseString((JsonString) object);
        }
        if (object instanceof JsonNumber) {
            return parseNumber((JsonNumber) object);
        }
        return parseObject((JsonObject) object);
    }

    @Override
    public JsonFieldFormatter getFieldFormatter() {
        return new JsonFieldFormatter() {
            @Override
            public String formate(JsonField field) {
                return "";
            }
        };
    }

    @Override
    public JsonObjectFormatter getObjectFormatter() {
        return new JsonObjectFormatter() {
            @Override
            public String formate(JsonObject object) {
                return "";
            }
        };
    }


    public String parseObject(JsonObject object) {
        StringBuilder json = new StringBuilder();

        json.append("{");
        int count = 0;
        int size = object.getFieldsCount();
        for (JsonField field : object.getFieldsSet()) {
            String parsedField = formate(field.getField());
            String parsedValue = formate(field.getValue());
            json.append(parsedField).append(":").append(parsedValue);
            if (count < size - 1) {
                json.append(",");
            }
            count++;
        }
        json.append("}");
        return json.toString();
    }

    public String parseString(JsonString object) {
        return "\"" + object.toString() + "\"";
    }

    public String parseNumber(JsonNumber object) {
        return object.toString();
    }
}