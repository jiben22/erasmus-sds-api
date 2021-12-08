package pl.poznan.put.ces.application;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.poznan.put.ces.domain.service.ErasmusStudentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            System.out.println("AUTHENTIFIE");

        } else {
            System.out.println("NON AUTHENTIFIE");
            // Tell to user is not correct
        }

        return "OK";
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
