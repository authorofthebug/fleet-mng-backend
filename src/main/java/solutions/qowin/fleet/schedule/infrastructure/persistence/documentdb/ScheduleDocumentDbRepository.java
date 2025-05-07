package solutions.qowin.fleet.schedule.infrastructure.persistence.documentdb;

import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;
import org.bson.types.ObjectId;

/**
 * MongoDB repository for Schedule entities.
 */
@MongoRepository
public interface ScheduleDocumentDbRepository extends CrudRepository<DocumentDbEntity, ObjectId> {
}