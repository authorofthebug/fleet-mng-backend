package solutions.qowin.fleet.schedule.infrastructure.persistence.documentdb;

import jakarta.inject.Singleton;
import lombok.extern.java.Log;
import org.bson.types.ObjectId;
import solutions.qowin.fleet.schedule.domain.model.Schedule;
import solutions.qowin.fleet.schedule.port.out.ScheduleRepository;

import java.util.List;
import java.util.Optional;

/**
 * MongoDB implementation of the ScheduleRepository interface.
 * This implementation is active in all environments, but uses mock data when MongoDB is not available.
 */
@Singleton
@Log
public class MongoRepositoryImpl implements ScheduleRepository {
    private final ScheduleDocumentDbRepository documentDbRepository;

    /**
     * Constructor with dependency injection
     *
     * @param documentDbRepository The MongoDB repository to use (can be null in non-prod environments)
     */
    public MongoRepositoryImpl(ScheduleDocumentDbRepository documentDbRepository) {
        this.documentDbRepository = documentDbRepository;

    }

    /**
     * Saves a schedule to the database or mock storage
     *
     * @param schedule The schedule to save
     * @return The saved schedule with updated information
     */
    @Override
    public Schedule save(Schedule schedule) {
            try {
                DocumentDbEntity entity = EntityMapper.toEntity(schedule);
                DocumentDbEntity savedEntity = documentDbRepository.save(entity);
                return EntityMapper.toDomainModel(savedEntity);
            } catch (Exception e) {
                log.severe("Error saving schedule to MongoDB"+ e);
            }
            throw new RuntimeException("Failed to save schedule");
    }

    /**
     * Finds a schedule by its ID from the database or mock storage
     *
     * @param id The ID of the schedule to find
     * @return An Optional containing the schedule if found, or empty if not found
     */
    @Override
    public Optional<Schedule> findById(String id) {
        if (id == null) {
            return Optional.empty();
        }

            try {
                return documentDbRepository.findById(new ObjectId(id))
                        .map(EntityMapper::toDomainModel);
            } catch (Exception e) {
                log.severe("Error finding schedule in MongoDB with ID: {}"+ id+ e);
            }
        throw new RuntimeException("Failed to find schedule");
    }

    /**
     * Deletes a schedule from the database or mock storage
     *
     * @param schedule The schedule to delete
     */
    @Override
    public void delete(Schedule schedule) {
        if (schedule == null || schedule.getId() == null) {
            return;
        }

            // Real MongoDB implementation
            try {
                DocumentDbEntity entity = EntityMapper.toEntity(schedule);
                documentDbRepository.delete(entity);
            } catch (Exception e) {
                log.severe("Error deleting schedule from MongoDB with ID: {}"+ schedule.getId()+ e);
                // Fallback to mock implementation
            }
        }

    @Override
    public void deleteById(String id) {
        if (id == null) {
            return;
        }

        try {
            documentDbRepository.deleteById(new ObjectId(id));
        } catch (Exception e) {
            log.severe("Error deleting schedule from MongoDB with ID: {}"+ id+e);
        }
    }

    @Override
    public List<Schedule> findAll() {
        return documentDbRepository.findAll().stream()
            .map(EntityMapper::toDomainModel)
            .toList();
    }


}
