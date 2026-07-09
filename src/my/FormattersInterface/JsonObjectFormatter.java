package my.FormattersInterface;

import my.Entities.JsonObject;

public interface JsonObjectFormatter {
    String formate(JsonObject object);

    void setFormatter(Formatter formatter);
}
