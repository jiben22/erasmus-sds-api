package pl.poznan.put.ces.domain.entity;

import lombok.Getter;
import lombok.NonNull;
import pl.poznan.put.ces.domain.entity.enums.Diploma;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Course entity
 */
@Entity
@Table(name = "Course")
@Getter
public class Course implements Serializable {

    /**
     * Course title
     */
    @Id
    @Column(nullable = false)
    @Size(min = 1)
    @NonNull
    private String title;

    /**
     * Description
     */
    @Lob
    @Column(nullable = false)
    @Size(min = 1)
    @NonNull
    private String description;

    /**
     * Ects
     */
    @Column(nullable = false)
    @Size(min = 1)
    @NonNull
    private Integer ects;

    /**
     * Hours
     */
    @Column(nullable = false)
    @Size(min = 1)
    @NonNull
    private Integer hours;

    /**
     * Description Card
     */
    @Column(nullable = false)
    @Size(min = 1)
    @NonNull
    private String descriptionCard;

    /**
     * Diploma
     */
    @Column(nullable = false)
    @Size(min = 1)
    @NonNull
    private Diploma diploma;
}
