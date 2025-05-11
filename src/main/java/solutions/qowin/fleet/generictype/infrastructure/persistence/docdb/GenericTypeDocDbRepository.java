package solutions.qowin.fleet.generictype.infrastructure.persistence.docdb;

import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;
import org.bson.types.ObjectId;

import java.util.List;

@MongoRepository
public interface GenericTypeDocDbRepository extends CrudRepository<RdsEntity, ObjectId> {
    List<RdsEntity> findByStatus(String status);
    List<RdsEntity> findByCategoryAndStatus(String category, String status);
} 