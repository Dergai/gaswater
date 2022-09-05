package test.task.gaswater.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import test.task.gaswater.model.entity.Measurement;

@Repository
public interface MeasurementRepository extends CrudRepository<Measurement, Long> {
}
