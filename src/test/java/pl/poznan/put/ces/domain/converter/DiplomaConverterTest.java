package pl.poznan.put.ces.domain.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.poznan.put.ces.domain.entity.converter.DiplomaConverter;
import pl.poznan.put.ces.domain.entity.enums.Diploma;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DiplomaConverterTest {

    @Mock
    DiplomaConverter diplomaConverter;

    @DisplayName("Convert diploma to database column")
    @Test()
    public void convertToDatabaseColumn() {
        Diploma diploma = Diploma.BSC;
        when(diplomaConverter.convertToDatabaseColumn(any(Diploma.class))).thenCallRealMethod();
        assertEquals(diploma.value, diplomaConverter.convertToDatabaseColumn(diploma));
    }

    @DisplayName("Convert diploma to entity attribute")
    @Test()
    public void convertToEntityAttribute() {
        Diploma diploma = Diploma.BSC;
        when(diplomaConverter.convertToEntityAttribute(anyString())).thenCallRealMethod();
        assertEquals(diploma, diplomaConverter.convertToEntityAttribute(diploma.name));
    }
}
