package solutions.qowin.fleet.vehicle.infrastructure.persistence.documentdb;

import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;
import org.bson.types.ObjectId;

@MongoRepository
public interface VehicleDocDbRepository extends CrudRepository<VehicleDocDbEntity, ObjectId> {
} 