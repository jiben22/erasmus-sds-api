package pl.poznan.put.ces.domain.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Diploma enumeration
 */
@AllArgsConstructor
@Getter
public enum Diploma {

    BSC("BSC", "B.Sc."),
    MASTER("MASTER", "Master"),
    PHD("PHD", "Phd");

    public final String value;
    public final String name;
}
