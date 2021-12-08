package pl.poznan.put.ces.domain.entity.password;

import lombok.Getter;
import lombok.Setter;
import pl.poznan.put.ces.application.constraint.FieldMatch;
import pl.poznan.put.ces.application.constraint.ValidPassword;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@FieldMatch(first = "password", second = "confirmPassword", message = "Passwords must match")
public class PasswordReset {
    @ValidPassword
    @NotEmpty
    private String password;
    @ValidPassword
    @NotEmpty
    private String confirmPassword;

    @NotEmpty
    private String token;

}