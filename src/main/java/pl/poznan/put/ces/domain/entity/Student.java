package pl.poznan.put.ces.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Profile entity
 */
@Entity
@Table(name = "Student")
@NoArgsConstructor
@Getter
public class Student extends Profile implements Serializable {

//    @Builder
//    public Student(String email, String firstname, String lastname, String password) {
//        super(email, firstname, lastname, password);
//    }
}
