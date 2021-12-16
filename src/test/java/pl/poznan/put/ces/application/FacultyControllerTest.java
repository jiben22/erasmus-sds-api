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
import pl.poznan.put.ces.application.constants.Constants;
import pl.poznan.put.ces.domain.factory.FacultyFactory;
import pl.poznan.put.ces.domain.service.FacultyService;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static pl.poznan.put.ces.application.constants.Constants.FacultyController.BASE_URL;
import static pl.poznan.put.ces.application.constants.Constants.FacultyController.GET_FACULTY_URL;

@ExtendWith(MockitoExtension.class)
public class FacultyControllerTest {
    @Mock
    private WebApplicationContext wac;

    @Mock
    private FacultyService facultyService;

    @InjectMocks
    private FacultyController facultyController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(facultyController).build();
    }

    @DisplayName("Get faculties")
    @Test
    public void getFaculties() throws Exception {
        Mockito.when(facultyService.getFaculties()).thenReturn(List.of(FacultyFactory.getArchitectureFaculty(),
                FacultyFactory.getComputingTelecommunicationsFaculty()));
        mockMvc.perform(get(BASE_URL))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"id\":\"architecture\",\"name\":\"Architecture\",\"imageUrl\":\"faculty-architecture.webp\"},{\"id\":\"computing-telecommunications\",\"name\":\"Computing and Telecommunications\",\"imageUrl\":\"faculty-computing-telecommunications.webp\"}]"));
    }

    //TODO: define param as "id“ field
    @DisplayName("Get faculty")
    @Test
    public void getFaculty() throws Exception {
        Mockito.when(facultyService.getFaculty(anyString())).thenReturn(FacultyFactory.getArchitectureFaculty());
        mockMvc.perform(get(String.format("%s/%s", BASE_URL, GET_FACULTY_URL), FacultyFactory.getArchitectureFaculty().getId()))
//                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":\"architecture\",\"name\":\"Architecture\",\"imageUrl\":\"faculty-architecture.webp\"}"));
    }

    //TODO: add case when facultyId not exist
}
