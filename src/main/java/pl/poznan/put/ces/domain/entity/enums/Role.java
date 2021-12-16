package pl.poznan.put.ces.domain.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {

    ERASMUS_STUDENT("Erasmus student"),
    ERASMUS_CANDIDATE("Erasmus candidate");

    public final String label;
}
