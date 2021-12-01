package pl.poznan.put.ces.domain.entity.converter;

import pl.poznan.put.ces.domain.entity.enums.Semester;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

/**
 * Convert enumeration named 'semester' to switch between database and java object and vice-versa
 * see(https://www.baeldung.com/jpa-persisting-enums-in-jpa#converter)
 *
 * @see pl.poznan.put.ces.domain.entity.Course
 */
@Converter(autoApply = true)
public class SemesterConverter implements AttributeConverter<Semester, String> {
    /**
     * Converts the value stored in the entity attribute into the
     * data representation to be stored in the database.
     *
     * @param semester the entity attribute value to be converted
     * @return the converted data to be stored in the database
     * column
     */
    @Override
    public String convertToDatabaseColumn(Semester semester) {
        if(semester == null){
            return null;
        }
        return semester.value;
    }

    /**
     * Converts the data stored in the database column into the
     * value to be stored in the entity attribute.
     * Note that it is the responsibility of the converter writer to
     * specify the correct <code>dbData</code> type for the corresponding
     * column for use by the JDBC driver: i.e., persistence providers are
     * not expected to do such type conversion.
     *
     * @param name the data from the database column to be
     *               converted
     * @return the converted value to be stored in the entity
     * attribute
     */
    @Override
    public Semester convertToEntityAttribute(String name) {
        if (name == null) {
            return null;
        }

        return Stream.of(Semester.values())
                .filter(semester -> semester.name.equals(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
