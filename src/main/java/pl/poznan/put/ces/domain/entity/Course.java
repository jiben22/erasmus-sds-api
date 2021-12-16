package pl.poznan.put.ces.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import pl.poznan.put.ces.domain.entity.enums.Diploma;
import pl.poznan.put.ces.domain.entity.enums.Semester;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * Course entity
 */
@Entity
@Table(name = "Course")
@NoArgsConstructor
@Builder
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
    @NonNull
    private Integer ects;

    /**
     * Hours
     */
    @Column(nullable = false)
    @NonNull
    private Integer hours;

    /**
     * Semester
     */
    @Column(nullable = false)
    @NonNull
    private Semester semester;

    /**
     * Description Card
     */
    @Column(nullable = false)
    @Size(min = 1)
    @NonNull
    private String descriptionCardUrl;

    /**
     * Diploma
     */
    @Column(nullable = false)
    @NonNull
    private Diploma diploma;

    /**
     * Faculty
     */
    @ManyToOne
    @JoinColumn(name="facultyId", referencedColumnName="id", nullable=false)
    @JsonBackReference
    @NonNull
    private Faculty faculty;

    /**
     * Represent list of coordinators link to the current course
     */
    @ManyToMany
    @JoinColumn(name="coordinatorEmail", referencedColumnName="email", nullable=false)
    @JsonManagedReference
    @NonNull
    private Set<Coordinator> coordinators;

    /**
     * Constructor of a Course
     */
    @Builder
    public Course(String id,
                   String title,
                   String description,
                   Integer ects,
                   Integer hours,
                   Semester semester,
                   String descriptionCardUrl,
                   Diploma diploma,
                   Faculty faculty,
                  Set<Coordinator> coordinators) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.ects = ects;
        this.hours = hours;
        this.semester = semester;
        this.descriptionCardUrl = descriptionCardUrl;
        this.diploma = diploma;
        this.faculty = faculty;
        this.coordinators = coordinators;
    }
}
