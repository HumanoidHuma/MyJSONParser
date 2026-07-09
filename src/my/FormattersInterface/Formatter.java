package my.FormattersInterface;

import my.Entities.EntitiesInterface.JsonValue;

public interface Formatter {
    String formate(JsonValue object);

    JsonFieldFormatter getFieldFormatter();

    JsonObjectFormatter getObjectFormatter();

    void setFieldFormatter(JsonFieldFormatter fieldFormatter);

    void setObjectFormatter(JsonObjectFormatter objectFormatter);
}