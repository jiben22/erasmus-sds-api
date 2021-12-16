package pl.poznan.put.ces.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * Coordinator entity
 */
@Entity
@Table(name = "Coordinator")
@NoArgsConstructor
@Builder
@Getter
public class Coordinator implements Serializable {

    /**
     * Firstname
     */
    @Column(nullable = false)
    @Size(min = 1)
    @NonNull
    private String name;

    /**
     * Lastname
     */
    @Column(nullable = false)
    @Size(min = 1)
    @NonNull
    private String lastName;

    /**
     * Email
     */
    @Id
    @Email
    @Column(length = 128)
    private String email;

    /**
     * Course
     */
    @ManyToMany
    @JoinColumn(name="courseId", referencedColumnName="id", nullable=false)
    @JsonBackReference
    @NonNull
    private Set<Course> courses;

    /**
     * Constructor of a Coordinator
     */
    @Builder
    public Coordinator(String name, String lastName, String email, Set<Course> courses) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.courses = courses;
    }
}
