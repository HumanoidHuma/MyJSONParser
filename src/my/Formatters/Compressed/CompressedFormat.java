package my.Formatters.Compressed;

import my.Entities.*;
import my.Entities.EntitiesInterface.*;
import my.FormattersInterface.Formatter;
import my.FormattersInterface.JsonFieldFormatter;
import my.FormattersInterface.JsonObjectFormatter;

public class CompressedFormat implements Formatter {
    private JsonFieldFormatter fieldFormatter;
    private JsonObjectFormatter objectFormatter;

    public CompressedFormat(JsonFieldFormatter fieldFormatter, JsonObjectFormatter objectFormatter) {
        this.fieldFormatter = fieldFormatter;
        this.objectFormatter = objectFormatter;
    }

    public CompressedFormat() {
        this.fieldFormatter = new CompressedFieldFormat(this);
        this.objectFormatter = new CompressedObjectFormat(this);
    }

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
        if (object instanceof JsonField) {
            return fieldFormatter.formate((JsonField) object);
        }
        return objectFormatter.formate((JsonObject) object);
    }

    @Override
    public JsonFieldFormatter getFieldFormatter() {
        return fieldFormatter;
    }

    @Override
    public JsonObjectFormatter getObjectFormatter() {
        return objectFormatter;
    }

    @Override
    public void setFieldFormatter(JsonFieldFormatter fieldFormatter) {
        this.fieldFormatter = fieldFormatter;
    }

    @Override
    public void setObjectFormatter(JsonObjectFormatter objectFormatter) {
        this.objectFormatter = objectFormatter;
    }

    public String parseString(JsonString object) {
        return "\"" + object.toString() + "\"";
    }

    public String parseNumber(JsonNumber object) {
        return object.toString();
    }

}