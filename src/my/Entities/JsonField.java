package my.Entities;

import my.Entities.EntitiesInterface.JsonValue;

public class JsonField implements JsonValue {
    private JsonString field;
    private JsonValue value;

    public JsonField() {}

    public JsonField(JsonString field, JsonValue value) {
        this.field = field;
        this.value = value;
    }

    public JsonString getField() {
        return field;
    }

    public JsonValue getValue() {
        return value;
    }

    public void setField(JsonString field) {
        this.field = field;
    }

    public void setValue(JsonValue value) {
        this.value = value;
    }
}