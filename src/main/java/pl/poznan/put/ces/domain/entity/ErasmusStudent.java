package pl.poznan.put.ces.domain.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Erasmus student entity
 */
@Entity
@Table(name = "ErasmusStudent")
@Getter
public class ErasmusStudent extends Profile implements Serializable {

    @Builder
    private ErasmusStudent(String lastname, String firstname, String email, String password) {
        super(lastname, firstname, email, password);
    }
}
