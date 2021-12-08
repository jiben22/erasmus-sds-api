package pl.poznan.put.ces.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Erasmus student entity
 */
@Entity
@Table(name = "ErasmusStudent")
@NoArgsConstructor
@Getter
public class ErasmusStudent extends Profile implements Serializable {

//    @Builder
//    public ErasmusStudent(String lastname, String firstname, String email, String password) {
//        super(lastname, firstname, email, password);
//    }
}
