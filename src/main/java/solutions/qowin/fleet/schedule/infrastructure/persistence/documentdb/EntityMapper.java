package solutions.qowin.fleet.schedule.infrastructure.persistence.documentdb;

import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import solutions.qowin.fleet.schedule.domain.model.Schedule;

/**
 * Mapper class to convert between Schedule domain model and DocumentDbEntity
 */
@Singleton
public class EntityMapper {
    private static final Logger LOG = LoggerFactory.getLogger(EntityMapper.class);

    /**
     * Converts a Schedule domain model to a DocumentDbEntity
     *
     * @param schedule The Schedule domain model to convert
     * @return The corresponding DocumentDbEntity
     */
    public static DocumentDbEntity toEntity(Schedule schedule) {
        if (schedule == null) {
            return null;
        }

        DocumentDbEntity entity = new DocumentDbEntity();

        // Convert Long id to String for MongoDB
        if (schedule.getId() != null) {
            entity.setId(schedule.getId().toString());
        }

        // Map fields from domain model to entity
        entity.setCode(schedule.getCode());
        entity.setName(schedule.getName());
        entity.setDescription(schedule.getDescription());
        entity.setStatus(schedule.getStatus());

        LOG.debug("Mapped domain model to entity: {}", entity);
        return entity;
    }

    /**
     * Converts a DocumentDbEntity to a Schedule domain model
     *
     * @param entity The DocumentDbEntity to convert
     * @return The corresponding Schedule domain model
     */
    public static Schedule toDomainModel(DocumentDbEntity entity) {
        if (entity == null) {
            return null;
        }

        Schedule schedule = new Schedule();

        // Convert String id to Long for domain model
        if (entity.getId() != null) {
            try {
                schedule.setId(Long.parseLong(entity.getId()));
            } catch (NumberFormatException e) {
                LOG.warn("Could not convert MongoDB ID to Long: {}", entity.getId(), e);
                // Use a default ID or handle as needed
                schedule.setId(0L);
            }
        }

        // Map fields from entity to domain model
        schedule.setCode(entity.getCode());
        schedule.setName(entity.getName());
        schedule.setDescription(entity.getDescription());
        schedule.setStatus(entity.getStatus());

        LOG.debug("Mapped entity to domain model: {}", schedule);
        return schedule;
    }
}
