package pl.poznan.put.ces.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Testimonial entity
 */
@Entity
@Table(name = "Testimonial")
@NoArgsConstructor
@Builder
@Getter
public class Testimonial implements Serializable {

    /**
     * Testimonial id
     */
    @Id
    @Size(min = 1)
    @NonNull
    private String id;

    /**
     * Erasmus student
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "erasmusStudentEmail", referencedColumnName = "email", nullable = false)
    @NonNull
    private ErasmusStudent erasmusStudent;

    /**
     * Date
     */
    @Column(nullable = false)
    @NonNull
    private LocalDateTime date;

    /**
     * Comment
     */
    @Column(nullable = false)
    @Size(min = 1)
    @NonNull
    private String comment;

    @ManyToOne
    @JoinColumn(name="courseId", referencedColumnName="id", nullable=false)
    @JsonBackReference
    @NonNull
    private Course course;

    /**
     * Constructor of a Testimonial
     */
    @Builder
    public Testimonial(String id,
                       ErasmusStudent erasmusStudent,
                       LocalDateTime date,
                       String comment,
                       Course course) {
        this.id = id;
        this.erasmusStudent = erasmusStudent;
        this.date = date;
        this.comment = comment;
        this.course = course;
    }
}
