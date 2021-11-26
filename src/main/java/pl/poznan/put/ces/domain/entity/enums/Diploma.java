package pl.poznan.put.ces.domain.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Diploma enumeration
 */
@AllArgsConstructor
@Getter
public enum Diploma {

    BSC("Bsc", "BSC"),
    MASTER("Master", "MASTER"),
    PHD("Phd", "PHD");

    public final String name;
    public final String value;
}
