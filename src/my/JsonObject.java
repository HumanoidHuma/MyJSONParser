package my;

import java.util.ArrayList;
import java.util.List;

public class JsonObject {
    private List<JsonField> fields = new ArrayList<>();

    public JsonObject() {}

    public JsonObject(List<JsonField> fields) {
        this.fields = fields;
    }

    public void putField(JsonField field) {
        fields.add(field);
    }

    public void putField(String field, String value) {
        fields.add(new JsonField(field, value));
    }

    public List<JsonField> getFields() {
        return fields;
    }

    public int getFieldsCount() {
        return fields.size();
    }
}