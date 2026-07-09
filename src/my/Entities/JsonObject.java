package my.Entities;

import my.Entities.EntitiesInterface.JsonValue;

import java.util.ArrayList;
import java.util.List;

public class JsonObject implements JsonValue {
    private List<JsonField> fieldsSet = new ArrayList<>();

    public JsonObject() {}

    public JsonObject(List<JsonField> fields) {
        fieldsSet = fields;
    }

    public List<JsonField> getFieldsSet() {
        return fieldsSet;
    }

    public void addField(JsonField newField) {
        fieldsSet.add(newField);
    }

    public int getFieldsCount() {
        return fieldsSet.size();
    }
}