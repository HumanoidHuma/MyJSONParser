package my.Formatters.Compressed;

import my.Entities.JsonField;
import my.Entities.JsonObject;
import my.FormattersInterface.Formatter;
import my.FormattersInterface.JsonObjectFormatter;

import java.util.List;

public class CompressedObjectFormat implements JsonObjectFormatter {
    private Formatter formatter;

    public CompressedObjectFormat(Formatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public String formate(JsonObject object) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        List<JsonField> fields = object.getFieldsSet();
        int count = 0;
        int size = fields.size();
        for (JsonField field : fields) {
            String filedJsonString = formatter.formate(field);
            sb.append(filedJsonString);
            if (count < size - 1) {
                sb.append(",");
            }
            count++;
        }
        sb.append("}");

        return sb.toString();
    }
}