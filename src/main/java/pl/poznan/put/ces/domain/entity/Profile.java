package pl.poznan.put.ces.domain.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Profile entity
 */
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class Profile implements Serializable {

    /**
     * Email
     */
    @Id
    @Email
    @Column(length = 128)
    private String email;

    /**
     * Firstname
     */
    @Column(nullable = false)
    @Size(min = 1)
    @NonNull
    private String firstname;

    /**
     * Lastname
     */
    @Column(nullable = false)
    @Size(min = 1)
    @NonNull
    private String lastname;

    /**
     * Password
     */
    @ToString.Exclude
    private String password;
}
