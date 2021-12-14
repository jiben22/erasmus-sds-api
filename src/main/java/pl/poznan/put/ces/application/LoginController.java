package pl.poznan.put.ces.application;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.jsonwebtoken.Jwts;
import org.springframework.web.bind.annotation.RestController;
import pl.poznan.put.ces.application.exception.UserNotFoundException;
import pl.poznan.put.ces.domain.service.ErasmusStudentService;

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
     * @return Bearer token
     */
    @GetMapping("/login")
    public String authenticateUser(@RequestParam("email") String email, @RequestParam("password") String password)
            throws UserNotFoundException {
        String token;
        if (erasmusStudentService.isAuthenticated(email, password)) {
            log.info("The user {} is authenticated", email);
            token = getJWTToken(email);
        } else {
            log.error("The user {} is not authenticated", email);
            throw new UserNotFoundException("Email or password invalid");
            //TODO: return specific message
        }

        return token;
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
