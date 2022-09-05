package test.task.gaswater.mapper;


import org.mapstruct.*;
import test.task.gaswater.config.MapStructConfig;
import test.task.gaswater.model.MeasurementDTO;
import test.task.gaswater.model.entity.Measurement;
import test.task.gaswater.model.entity.Person;

import java.util.Collection;
import java.util.Set;

@Mapper(config = MapStructConfig.class, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MeasurementMapper {
    MeasurementDTO toDTO(Measurement measurement);

    Set<MeasurementDTO> toDTOs(Collection<Measurement> measurements);

    Measurement fromDTO(MeasurementDTO measurementDTO, @Context Person person);

    @AfterMapping
    default void setPerson(MeasurementDTO measurementDTO, @MappingTarget Measurement measurement, @Context Person person) {
        measurement.setPerson(person);
    }

    void update(@MappingTarget Measurement measurement, MeasurementDTO measurementDTO);
}
