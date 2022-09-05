package test.task.gaswater.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import test.task.gaswater.model.MeasurementDTO;
import test.task.gaswater.service.PersonService;

import javax.validation.Valid;
import java.util.Set;

@Controller
@RequestMapping("/api/${api.person.version:v1}")
public class ApiController {

    private final Logger log = LoggerFactory.getLogger(ApiController.class);

    public final PersonService personService;

    @Autowired
    public ApiController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/person/{personId}/measurement", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<MeasurementDTO>> getMeasurementsForPerson(@PathVariable("personId") Long personId) {
        log.debug("Processing getMeasurementsForPerson request for person {}", personId);
        final Set<MeasurementDTO> personMeasurements = personService.getPersonMeasurements(personId);
        log.debug("getMeasurementsForPerson request for person {} processed", personId);
        return ResponseEntity.ok(personMeasurements);
    }

    @PatchMapping(value = "/person/{personId}/measurement", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MeasurementDTO> sendMeasurement(@Valid @RequestBody MeasurementDTO measurement,
                                                          @PathVariable("personId") Long personId) {
        log.debug("Processing sendMeasurement request for measurement {}", measurement);
        final MeasurementDTO personMeasurement = personService.sendMeasurement(measurement, personId);
        log.debug("sendMeasurement request for measurement {} processed", measurement);
        return ResponseEntity.ok(personMeasurement);
    }
}
