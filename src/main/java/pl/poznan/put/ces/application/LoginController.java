package pl.poznan.put.ces.application;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.poznan.put.ces.domain.entity.ErasmusStudent;
import pl.poznan.put.ces.domain.service.ErasmusStudentService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class LoginController {

    private final ErasmusStudentService erasmusStudentService;

    @Autowired
    public LoginController(ErasmusStudentService erasmusStudentService) {
        this.erasmusStudentService = erasmusStudentService;
    }

    /**
     * Authenticate user then generate JWT token
     * @param email email
     * @param password password
     * @return map with token, firstname and lastname of erasmus student
     */
    @GetMapping("/login")
    public ResponseEntity<Object> authenticateUser(@RequestParam("email") String email, @RequestParam("password") String password) {
        Map<String, Object> map = new HashMap<>();

        try {
            if (erasmusStudentService.isAuthenticated(email, password)) {
                log.info("The user {} is authenticated", email);
                String token = getJWTToken(email);
                ErasmusStudent erasmusStudent = erasmusStudentService.findByEmail(email);

                map.put("token", token);
                map.put("firstname", erasmusStudent.getFirstname());
                map.put("lastname", erasmusStudent.getLastname());
                map.put("email", erasmusStudent.getEmail());
            } else {
                log.error("The user {} is not authenticated", email);
                throw new Exception("Email or password invalid");
            }
        } catch (Exception e) {
            map.put("isSuccess", false);
            map.put("message", e.getMessage());
        }

        return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ERASMUS_STUDENT");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }

//    @GetMapping("/logout")
//    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
//
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null) {
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//
//        return "redirect:/connection";
//    }

}
