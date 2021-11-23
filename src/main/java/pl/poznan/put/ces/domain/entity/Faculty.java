package pl.poznan.put.ces.domain.entity;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * Faculty entity
 */
@Entity
@Table(name = "Faculty")
@Builder
@Getter
public class Faculty implements Serializable {

    /**
     * Faculty id
     */
    @Id
    @Size(min = 1)
    @NonNull
    private String id;


    /**
     * Name
     */
    @Column(nullable = false)
    @Size(min = 1)
    @NonNull
    private String name;

    /**
     * Image URL
     */
    @Column(nullable = false)
    @Size(min = 1)
    @NonNull
    private String imageUrl;

    /**
     * Represent list of courses link to the current faculty
     */
    @OneToMany(mappedBy="faculty")
    @JsonManagedReference
    private Set<Course> courses;

    /**
     * Constructor of a Faculty
     */
    @Builder
    private Faculty(String id, String name, String imageUrl, Set<Course> courses) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.courses = courses;
    }
}
