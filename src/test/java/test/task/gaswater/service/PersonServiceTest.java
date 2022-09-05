package test.task.gaswater.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import test.task.gaswater.model.entity.Person;
import test.task.gaswater.repository.PersonRepository;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest(classes = {
        PersonService.class
})
public class PersonServiceTest {
    @MockBean
    private PersonRepository personRepository;
    @MockBean
    private MeasurementService measurementService;
    @Autowired
    private PersonService personService;

    @Test
    public void testGet() {
        Person person = new Person();
        person.setId(1L);
        when(personRepository.findById(1L)).thenReturn(Optional.of(person));

        personService.getById(1L);

        Mockito.verify(personRepository, Mockito.times(1)).findById(1L);
    }

    //TODO +tests for each methods and  exceptions
    //TODO +MeasurementService tests
}
