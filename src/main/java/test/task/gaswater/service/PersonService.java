package test.task.gaswater.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.task.gaswater.exception.ResourceNotFoundException;
import test.task.gaswater.model.MeasurementDTO;
import test.task.gaswater.model.MeasurementType;
import test.task.gaswater.model.entity.Measurement;
import test.task.gaswater.model.entity.Person;
import test.task.gaswater.repository.PersonRepository;

import javax.annotation.PostConstruct;
import java.util.Objects;
import java.util.Set;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final MeasurementService measurementService;

    @Autowired
    public PersonService(PersonRepository personRepository, MeasurementService measurementService) {
        this.personRepository = personRepository;
        this.measurementService = measurementService;
    }

    @PostConstruct
    public void init() {
        //TODO added few rows for testing
        Person person1 = new Person();
        person1.setName("name1");
        Person person2 = new Person();
        person2.setName("name2");
        personRepository.save(person1);
        personRepository.save(person2);

        MeasurementDTO measurementDTOGas1 = new MeasurementDTO();
        measurementDTOGas1.setMeter(10.23);
        measurementDTOGas1.setType(MeasurementType.GAS);

        MeasurementDTO measurementDTOWater1 = new MeasurementDTO();
        measurementDTOWater1.setMeter(310.23);
        measurementDTOWater1.setType(MeasurementType.WATER);

        MeasurementDTO measurementDTOGas2 = new MeasurementDTO();
        measurementDTOGas2.setMeter(510.23);
        measurementDTOGas2.setType(MeasurementType.GAS);

        measurementService.addMeasurement(measurementDTOGas1, person1);
        measurementService.addMeasurement(measurementDTOGas2, person2);
        measurementService.addMeasurement(measurementDTOWater1, person1);
    }

    public Set<MeasurementDTO> getPersonMeasurements(Long personId) {
        final Person person = getById(personId);
        return measurementService.convertMeasurements(person.getMeasurements());
    }

    @Transactional
    public MeasurementDTO sendMeasurement(MeasurementDTO measurementDTO, Long personId) {
        final Person person = getById(personId);
        final Measurement measurement = person.getMeasurements().stream()
                .filter(v -> Objects.equals(measurementDTO.getType(), v.getType()))
                .findAny()
                .orElseThrow(() -> new ResourceNotFoundException("Measurement with type = " + measurementDTO.getType() +
                        " not found for person id = " + personId));
        measurement.setMeter(measurementDTO.getMeter());
        return measurementService.updateMeasurement(measurement, measurementDTO);
    }

    public Person getById(Long personId) {
        return personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found by id = " + personId));
    }
}
