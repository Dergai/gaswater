package test.task.gaswater.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.task.gaswater.mapper.MeasurementMapper;
import test.task.gaswater.model.MeasurementDTO;
import test.task.gaswater.model.entity.Measurement;
import test.task.gaswater.model.entity.Person;
import test.task.gaswater.repository.MeasurementRepository;

import java.util.Set;

@Service
public class MeasurementService {
    private final MeasurementRepository measurementRepository;
    private final MeasurementMapper measurementMapper;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository, MeasurementMapper measurementMapper) {
        this.measurementRepository = measurementRepository;
        this.measurementMapper = measurementMapper;
    }

    public Set<MeasurementDTO> convertMeasurements(Set<Measurement> measurements) {
        return measurementMapper.toDTOs(measurements);
    }

    public MeasurementDTO updateMeasurement(Measurement measurement, MeasurementDTO measurementDTO) {
        measurementMapper.update(measurement, measurementDTO);
        measurement = measurementRepository.save(measurement);
        return measurementMapper.toDTO(measurement);
    }

    public MeasurementDTO addMeasurement(MeasurementDTO measurementDTO, Person person) {
        Measurement measurement = measurementMapper.fromDTO(measurementDTO, person);
        measurement = measurementRepository.save(measurement);
        return measurementMapper.toDTO(measurement);
    }
}
