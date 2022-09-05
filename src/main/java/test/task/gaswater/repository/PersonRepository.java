package test.task.gaswater.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import test.task.gaswater.model.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
