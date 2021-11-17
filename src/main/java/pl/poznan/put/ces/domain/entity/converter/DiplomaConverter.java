package pl.poznan.put.ces.domain.entity.converter;

import pl.poznan.put.ces.domain.entity.enums.Diploma;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

/**
 * Convert enumeration named 'diploma' to switch between database and java object and vice-versa
 * see(https://www.baeldung.com/jpa-persisting-enums-in-jpa#converter)
 *
 * @see pl.poznan.put.ces.domain.entity.Course
 */
@Converter(autoApply = true)
public class DiplomaConverter implements AttributeConverter<Diploma, String> {
    /**
     * Converts the value stored in the entity attribute into the
     * data representation to be stored in the database.
     *
     * @param diploma the entity attribute value to be converted
     * @return the converted data to be stored in the database
     * column
     */
    @Override
    public String convertToDatabaseColumn(Diploma diploma) {
        if(diploma == null){
            return null;
        }
        return diploma.value;
    }

    /**
     * Converts the data stored in the database column into the
     * value to be stored in the entity attribute.
     * Note that it is the responsibility of the converter writer to
     * specify the correct <code>dbData</code> type for the corresponding
     * column for use by the JDBC driver: i.e., persistence providers are
     * not expected to do such type conversion.
     *
     * @param value the data from the database column to be
     *               converted
     * @return the converted value to be stored in the entity
     * attribute
     */
    @Override
    public Diploma convertToEntityAttribute(String name) {
        if (name == null) {
            return null;
        }

        return Stream.of(Diploma.values())
                .filter(diploma -> diploma.name.equals(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
