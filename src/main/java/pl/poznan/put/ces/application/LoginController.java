package pl.poznan.put.ces.application;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.jsonwebtoken.Jwts;
import pl.poznan.put.ces.domain.service.ErasmusStudentService;

@RequiredArgsConstructor
@Controller
public class LoginController {

    @Autowired
    private ErasmusStudentService erasmusStudentService;

    @GetMapping("/login")
    public String authenticateUser(@RequestParam("email") String email, @RequestParam("password") String password) {
        if (erasmusStudentService.isAuthenticated(email, password)) {
            // Send email + firstname + lastname
            // Token
            String token = null;
            try{
                 token = getJWTToken(email);
            } catch (Exception e) {
                System.out.println("error");
            }
            System.out.println("AUTHENTIFIE");
            return token;
        } else {
            System.out.println("NON AUTHENTIFIE");
            return null;
            // Tell to user is not correct
        }
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
