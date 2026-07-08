package my;

public class JsonField {
    private String field;
    private String value;

    public JsonField(String field, String value) {
        this.field = field;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public String getValue() {
        return value;
    }
}
