package pl.poznan.put.ces.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.poznan.put.ces.domain.factory.CourseFactory;
import pl.poznan.put.ces.domain.factory.FacultyFactory;
import pl.poznan.put.ces.domain.service.CourseService;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static pl.poznan.put.ces.application.constants.Constants.CourseController.BASE_URL;

@ExtendWith(MockitoExtension.class)
public class CourseControllerTest {
    @Mock
    private WebApplicationContext wac;

    @Mock
    private CourseService courseService;

    @InjectMocks
    private CourseController courseController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(courseController).build();
    }

    @DisplayName("Get courses")
    @Test
    public void getCourses() throws Exception {
        Mockito.when(courseService.getCourses(anyString(), any())).thenReturn(List.of(CourseFactory.getObjectProgrammingCourse(),
                CourseFactory.getSoftwareDevelopmentStudio2Course()));
        mockMvc.perform(get(BASE_URL, FacultyFactory.getComputingTelecommunicationsFaculty().getId()))
//                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"id\":\"object-programming\",\"title\":\"Object Programming\",\"description\":\"The goal of the course is to teach students how to model and create reusable, easily-maintainable software, by using tools provided by object-oriented programming languages. Moreover, the students will learn how to create and use custom data types, how to model software systems based on clean code principles, and how to communicate their work to other programmers.\",\"ects\":4,\"hours\":60,\"semester\":\"WINTER\",\"descriptionCardUrl\":\"Object-programming.pdf\",\"diploma\":\"BSC\",\"coordinators\":null},{\"id\":\"quality-management-experimental-software-engineering\",\"title\":\"Quality Management and Experimental Software Engineering\",\"description\":\"Provide students the knowledge regarding experimental Software Engineering, especially related to empirical research methods and their theoretical foundations.\",\"ects\":5,\"hours\":60,\"semester\":\"WINTER\",\"descriptionCardUrl\":\"Quality-management-and-experimental-software-engineering.pdf\",\"diploma\":\"MASTER\",\"coordinators\":null}]"));
    }

//    @DisplayName("Get faculty")
//    @Test
//    public void getFaculty() throws Exception {
//        Mockito.when(facultyService.getFaculty(anyString())).thenReturn(FacultyFactory.getArchitectureFaculty());
//        mockMvc.perform(get(String.format("%s/%s", BASE_URL, GET_FACULTY_URL))
//                        .requestAttr("id", FacultyFactory.getArchitectureFaculty().getId()))
//                .andExpect(status().isOk())
//                .andExpect(content().string("{\"id\":\"architecture\",\"name\":\"Architecture\",\"imageUrl\":\"faculty-architecture.webp\"}"));
//    }

    //TODO: add case when facultyId not exist
}
