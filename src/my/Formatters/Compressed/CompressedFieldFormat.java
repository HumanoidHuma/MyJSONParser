package my.Formatters.Compressed;

import my.Entities.JsonField;
import my.FormattersInterface.Formatter;
import my.FormattersInterface.JsonFieldFormatter;

public class CompressedFieldFormat implements JsonFieldFormatter {
    private Formatter formatter;

    public CompressedFieldFormat(Formatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public String formate(JsonField field) {
        return formatter.formate(field.getField()) + ":" + formatter.formate(field.getValue());
    }
}
