package my.Entities;

import my.Entities.EntitiesInterface.JsonValue;

public class JsonNull implements JsonValue {
    private static final JsonNull INSTANCE = new JsonNull();

    private JsonNull() {}

    public static JsonNull getInstance() {
        return INSTANCE;
    }
}
