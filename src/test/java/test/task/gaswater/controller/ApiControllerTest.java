package test.task.gaswater.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import test.task.gaswater.config.ExceptionHandlerControllerAdvice;
import test.task.gaswater.service.PersonService;

import java.util.HashSet;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EnableWebMvc
@AutoConfigureMockMvc
@SpringBootTest(classes = {ExceptionHandlerControllerAdvice.class, ApiController.class})
public class ApiControllerTest {
    @MockBean
    private PersonService personService;

    @Autowired
    private MockMvc mockMvc;

    @Value("${api.person.version:v1}")
    private String apiVersion;

    @Test
    @SneakyThrows
    public void testGetMetrics_success() {
        when(personService.getPersonMeasurements(1L)).thenReturn(new HashSet<>());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/" + apiVersion + "/person/1/measurement")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        Mockito.verify(personService, Mockito.times(1)).getPersonMeasurements(1L);
    }

    //TODO test successfull for each method.
    //TODO test for each exception
    //TODO test for Invalid DATA
}
