package pl.poznan.put.ces.application.constants;

public class Constants {

    public static final class FacultyController {
        private FacultyController() {}

        public static final String BASE_URL = "/faculties";
        public static final String GET_FACULTY_URL = "/{id}";
    }

    public static final class CourseController {
        private CourseController() {}

        public static final String BASE_URL = "/faculties/{facultyId}/courses";
        public static final String GET_COURSE_URL = "/{id}";
    }

    public static final class PasswordForgotController {

        private PasswordForgotController() {}

        public static final String PASSWORD_FORGOT = "forgotPasswordForm";
        public static final String BASE_URL = "/reinitialize-password";
        public static final String TITLE = "Request password";
        public static final String VIEW = "forgotPassword";
    }

    public static final class PasswordResetController {

        private PasswordResetController() {}

        public static final String PASSWORD_RESET = "passwordResetForm";
        public static final String BASE_URL = "/resetPassword/{option}";
        public static final String TITLE = "Resetting the password";
        public static final String REDIRECT_URL_FAIL = "redirect:/resetPassword/%s?token=%s";
        public static final String REDIRECT_URL_SUCCESS = "redirect:/connection?resetSuccess";
        public static final String VIEW = "resetPassword";
    }
}