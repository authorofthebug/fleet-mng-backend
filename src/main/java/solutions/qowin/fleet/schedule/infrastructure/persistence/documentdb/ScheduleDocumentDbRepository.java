package solutions.qowin.fleet.schedule.infrastructure.persistence.documentdb;

import io.micronaut.context.annotation.Requires;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;

/**
 * MongoDB repository for Schedule entities.
 */
@MongoRepository
public interface ScheduleDocumentDbRepository extends CrudRepository<DocumentDbEntity, String> {
}