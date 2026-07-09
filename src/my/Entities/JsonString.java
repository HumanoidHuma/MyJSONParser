package my.Entities;

import my.Entities.EntitiesInterface.JsonValue;

public class JsonString implements JsonValue {
    private String value;

    public JsonString(String input) {
        value = input;
    }

    @Override
    public String toString() {
        return value;
    }

    public String get() {
        return value;
    }

    public void set(String input) {
        value = input;
    }
}
