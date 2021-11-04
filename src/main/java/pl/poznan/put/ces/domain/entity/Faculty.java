package pl.poznan.put.ces.domain.entity;

import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Faculty entity
 */
@Entity
@Table(name = "Faculty")
@Getter
public class Faculty implements Serializable {

    /**
     * Faculty name
     */
    @Id
    @Column(nullable = false)
    @Size(min = 1)
    @NonNull
    private String name;

    /**
     * Description
     */
    @Column(nullable = false)
    @Size(min = 1)
    @NonNull
    private String description;

    /**
     * Image URL
     */
    @Column(nullable = false)
    @Size(min = 1)
    @NonNull
    private String image;
}
