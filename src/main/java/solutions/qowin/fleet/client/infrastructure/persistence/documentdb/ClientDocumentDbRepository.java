package solutions.qowin.fleet.client.infrastructure.persistence.documentdb;

import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;
import org.bson.types.ObjectId;

@MongoRepository
public interface ClientDocumentDbRepository extends CrudRepository<ClientDocumentDbEntity, ObjectId> {
} 