package springbasic.web.converter;

import jakarta.persistence.AttributeConverter;

/**
 * emptyString to null
 */
//@Converter(autoApply = true)
public class EmptyStringToNullConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String str) {
        return "".equals(str) ? null : str;
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return dbData;
    }
}
