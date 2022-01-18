package pl.poznan.put.ces.domain.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Profile entity
 */
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
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

    /**
     * Override Lombok Setter to encode password
     *
     * @param password Password of the employee to encode
     */
    public void setPassword(String password) {
        this.password = encodePassword(password);
    }

    /**
     * Used to encode a password
     */
    public static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     * Encode a password
     *
     * @param password Password to encode
     * @return Encoded password
     */
    public static String encodePassword(@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*])(?=.{10,})", message = "The password must contain an upper case, a lower case, a number and a special character (!@#$%^&*). It has to have a minimum size of 10 characters") String password) {
        return encoder.encode(password);
    }

    /**
     *
     * Check that the password matches with password of the employee
     *
     * @param password Password to check
     * @return password match or not
     */
    public boolean matchesPassword(String password) {
        return encoder.matches(password, this.password);
    }

}
