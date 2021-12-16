package pl.poznan.put.ces.domain.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.poznan.put.ces.domain.entity.converter.SemesterConverter;
import pl.poznan.put.ces.domain.entity.enums.Semester;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SemesterConverterTest {

    @Mock
    SemesterConverter semesterConverter;

    @DisplayName("Convert semester to database column")
    @Test()
    public void convertToDatabaseColumn() {
        Semester semester = Semester.WINTER;
        when(semesterConverter.convertToDatabaseColumn(any(Semester.class))).thenCallRealMethod();
        assertEquals(semester.value, semesterConverter.convertToDatabaseColumn(semester));
    }

    @DisplayName("Convert semester to entity attribute")
    @Test()
    public void convertToEntityAttribute() {
        Semester semester = Semester.WINTER;
        when(semesterConverter.convertToEntityAttribute(anyString())).thenCallRealMethod();
        assertEquals(semester, semesterConverter.convertToEntityAttribute(semester.name));
    }
}
