package pl.poznan.put.ces.domain.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Semester enumeration
 */
@AllArgsConstructor
@Getter
public enum Semester {

    FALL("Fall", "FALL"),
    WINTER("Winter", "WINTER"),
    SPRING("Spring", "SPRING"),
    SUMMER("Summer", "SUMMER");

    public final String name;
    public final String value;
}
