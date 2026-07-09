package my.Entities;

import my.Entities.EntitiesInterface.JsonValue;

public class JsonNumber implements JsonValue {
    private Number number;

    public JsonNumber(Number number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return number.toString();
    }

    public Number get() {
        return number;
    }

    public void set(Number number) {
        this.number = number;
    }
}
