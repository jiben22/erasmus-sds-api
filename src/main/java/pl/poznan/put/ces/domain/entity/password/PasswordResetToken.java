package pl.poznan.put.ces.domain.entity.password;

import lombok.Data;
import pl.poznan.put.ces.domain.entity.ErasmusStudent;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Data
public class PasswordResetToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String token;

    @ManyToOne(targetEntity = ErasmusStudent.class, fetch = FetchType.EAGER)
//    @JoinColumn(nullable = false, name = "id")
    private ErasmusStudent erasmusStudent;

    @Column(nullable = false)
    private Date expiryDate;

    public void setExpiryDate(int minutes) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE, minutes);
        this.expiryDate = now.getTime();
    }

    public boolean isExpired() {
        return new Date().after(this.expiryDate);
    }
}