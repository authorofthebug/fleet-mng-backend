package solutions.qowin.fleet.schedule.infrastructure.persistence.documentdb;

import jakarta.inject.Named;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import solutions.qowin.fleet.schedule.domain.model.Schedule;
import solutions.qowin.fleet.schedule.port.out.ScheduleRepository;
import solutions.qowin.fleet.schedule.shared.mappers.ScheduleUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * MongoDB implementation of the ScheduleRepository interface.
 * This implementation is active in all environments, but uses mock data when MongoDB is not available.
 */
@Singleton
public class MongoRepositoryImpl implements ScheduleRepository {
    private static final Logger LOG = LoggerFactory.getLogger(MongoRepositoryImpl.class);

    // Mock data storage
    private static final Map<Long, Schedule> mockSchedules = new HashMap<>();
    private static final AtomicLong idCounter = new AtomicLong(1);

    private final ScheduleDocumentDbRepository documentDbRepository;
    private final boolean useMockData;

    /**
     * Constructor with dependency injection
     *
     * @param documentDbRepository The MongoDB repository to use (can be null in non-prod environments)
     */
    public MongoRepositoryImpl(ScheduleDocumentDbRepository documentDbRepository) {
        this.documentDbRepository = documentDbRepository;
        this.useMockData = documentDbRepository == null;

        if (useMockData) {
            LOG.info("MongoDB repository not available. Using mock data.");
            // Initialize with some mock data
            ScheduleUtils.generateRandomSchedules(10).forEach(schedule -> {
                mockSchedules.put(schedule.getId(), schedule);
            });
        } else {
            LOG.info("Using MongoDB repository for schedule data.");
        }
    }

    /**
     * Saves a schedule to the database or mock storage
     *
     * @param schedule The schedule to save
     * @return The saved schedule with updated information
     */
    @Override
    public Schedule save(Schedule schedule) {
        if (useMockData) {
            // Mock implementation
            if (schedule.getId() == null) {
                // New schedule - assign an ID
                schedule.setId(idCounter.getAndIncrement());
                schedule.setCreatedAt(LocalDateTime.now());
            }
            schedule.setUpdatedAt(LocalDateTime.now());
            mockSchedules.put(schedule.getId(), schedule);
            return schedule;
        } else {
            // Real MongoDB implementation
            try {
                DocumentDbEntity entity = EntityMapper.toEntity(schedule);
                DocumentDbEntity savedEntity = documentDbRepository.save(entity);
                return EntityMapper.toDomainModel(savedEntity);
            } catch (Exception e) {
                LOG.error("Error saving schedule to MongoDB", e);
                // Fallback to mock implementation
                if (schedule.getId() == null) {
                    schedule.setId(idCounter.getAndIncrement());
                    schedule.setCreatedAt(LocalDateTime.now());
                }
                schedule.setUpdatedAt(LocalDateTime.now());
                mockSchedules.put(schedule.getId(), schedule);
                return schedule;
            }
        }
    }

    /**
     * Finds a schedule by its ID from the database or mock storage
     *
     * @param id The ID of the schedule to find
     * @return An Optional containing the schedule if found, or empty if not found
     */
    @Override
    public Optional<Schedule> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        }

        if (useMockData) {
            // Mock implementation
            return Optional.ofNullable(mockSchedules.get(id));
        } else {
            // Real MongoDB implementation
            try {
                return documentDbRepository.findById(id.toString())
                        .map(EntityMapper::toDomainModel);
            } catch (Exception e) {
                LOG.error("Error finding schedule in MongoDB with ID: {}", id, e);
                // Fallback to mock implementation
                return Optional.ofNullable(mockSchedules.get(id));
            }
        }
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

        if (useMockData) {
            // Mock implementation
            mockSchedules.remove(schedule.getId());
        } else {
            // Real MongoDB implementation
            try {
                DocumentDbEntity entity = EntityMapper.toEntity(schedule);
                documentDbRepository.delete(entity);
            } catch (Exception e) {
                LOG.error("Error deleting schedule from MongoDB with ID: {}", schedule.getId(), e);
                // Fallback to mock implementation
                mockSchedules.remove(schedule.getId());
            }
        }
    }

    /**
     * Deletes a schedule by its ID from the database or mock storage
     *
     * @param id The ID of the schedule to delete
     */
    @Override
    public void deleteById(Long id) {
        if (id == null) {
            return;
        }

        if (useMockData) {
            // Mock implementation
            mockSchedules.remove(id);
        } else {
            // Real MongoDB implementation
            try {
                documentDbRepository.deleteById(id.toString());
            } catch (Exception e) {
                LOG.error("Error deleting schedule from MongoDB with ID: {}", id, e);
                // Fallback to mock implementation
                mockSchedules.remove(id);
            }
        }
    }

    @Override
    public List<Schedule> findAll() {
        return documentDbRepository.findAll().stream()
                .map(EntityMapper::toDomainModel)
                .toList();
    }

    /**
     * Gets all schedules from the mock storage.
     * This method is not part of the ScheduleRepository interface but can be useful for testing.
     *
     * @return A list of all schedules in the mock storage
     */
    public List<Schedule> getAllMockSchedules() {
        return new ArrayList<>(mockSchedules.values());
    }
}
