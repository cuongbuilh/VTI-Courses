package entity.converter;

import entity.enums.PositionName;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class PositionNameConverter implements AttributeConverter<PositionName, String> {
    @Override
    public String convertToDatabaseColumn(PositionName attribute) {
        return attribute.getValue();
    }

    @Override
    public PositionName convertToEntityAttribute(String dbData) {
        return PositionName.of(dbData);
    }
}
