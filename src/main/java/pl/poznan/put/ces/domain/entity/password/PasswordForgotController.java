package pl.poznan.put.ces.domain.entity.password;

import pl.poznan.put.ces.application.constants.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.poznan.put.ces.infrastructure.PasswordResetTokenRepository;
import pl.poznan.put.ces.service.ErasmusStudentService;

import static pl.poznan.put.ces.application.constants.Constants.PasswordForgotController.*;

@RequiredArgsConstructor
@Controller
@RequestMapping(BASE_URL)
public class PasswordForgotController {

    /**
     * Service pour les collaborateurs
     */
    private final ErasmusStudentService erasmusStudentService;

    /**
     * Repository pour la réinitialisation d'un mot de passe
     */
    private final PasswordResetTokenRepository passwordResetTokenRepository;

    @ModelAttribute(PASSWORD_FORGOT)
    public PasswordForgot forgotPasswordDto() {
        return new PasswordForgot();
    }

    /**
     * Afficher la page de de demande du mot de passe
     * @return le formulaire pour la demande du mot de passe
     */
    @GetMapping
    public String showForgotPassword(Model springModel) {
        springModel.addAttribute(TITLE, Constants.PasswordForgotController.TITLE);
        return VIEW;
    }
}
