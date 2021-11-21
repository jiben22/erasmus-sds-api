package pl.poznan.put.ces.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NonNull;
import pl.poznan.put.ces.domain.entity.enums.Diploma;
import pl.poznan.put.ces.domain.entity.enums.Semester;

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
     * Course id
     */
    @Id
    @Size(min = 1)
    @NonNull
    private String id;

    /**
     * Course title
     */
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
     * Semester
     */
    @Column(nullable = false)
    @Size(min = 1)
    @NonNull
    private Semester semester;

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

    /**
     * Faculty
     */
    @ManyToOne
    @JoinColumn(name="faculty_id", nullable=false)
    @JsonBackReference
    @NonNull
    private Faculty faculty;
}
