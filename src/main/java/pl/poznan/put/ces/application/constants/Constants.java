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
}