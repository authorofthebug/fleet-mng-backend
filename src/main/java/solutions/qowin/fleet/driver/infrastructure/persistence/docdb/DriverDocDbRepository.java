package solutions.qowin.fleet.driver.infrastructure.persistence.docdb;

import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;
import org.bson.types.ObjectId;

@MongoRepository
public interface DriverDocDbRepository extends CrudRepository<DocDbEntity, ObjectId> {
} 