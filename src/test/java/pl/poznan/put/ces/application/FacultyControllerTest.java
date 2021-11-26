package pl.poznan.put.ces.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static pl.poznan.put.ces.application.constants.Constants.FacultyController.BASE_URL;

import pl.poznan.put.ces.domain.service.FacultyService;

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
        mockMvc.perform(get(BASE_URL))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
