package solutions.qowin.fleet.schedule.shared.mappers;

import jakarta.inject.Singleton;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import solutions.qowin.fleet.schedule.domain.model.Schedule;
import solutions.qowin.fleet.schedule.infrastructure.persistence.documentdb.DocumentDbEntity;

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
            entity.setId(new ObjectId(schedule.getId()));
        } else {
            entity.setId(new ObjectId());
        }
        entity.setClientId(schedule.getClientId());
        entity.setVehicleId(schedule.getVehicleId());
        entity.setOrigin(schedule.getOrigin());
        entity.setDestination(schedule.getDestination());
        entity.setStartTime(schedule.getStartTime());
        entity.setEndTime(schedule.getEndTime());
        entity.setDescription(schedule.getDescription());
        entity.setStatus(schedule.getStatus());
        entity.setCreatedAt(schedule.getCreatedAt());
        entity.setUpdatedAt(schedule.getUpdatedAt());
        entity.setPlate(schedule.getPlate());
        entity.setZone(schedule.getZone());
        entity.setDriverId(schedule.getDriverId());
        entity.setConditionType(schedule.getConditionType());
        entity.setVehicleType(schedule.getVehicleType());
        entity.setServiceType(schedule.getServiceType());


        LOG.info("Mapped domain model to entity: {}", entity);
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
                schedule.setId(entity.getId().toString());
            } catch (NumberFormatException e) {
                LOG.warn("Could not convert MongoDB ID to Long: {}", entity.getId(), e);
                // Use a default ID or handle as needed
                schedule.setId("0L");
            }
        }

        // Map fields from entity to domain model
        schedule.setClientId(entity.getClientId());
        schedule.setVehicleId(entity.getVehicleId());
        schedule.setOrigin(entity.getOrigin());
        schedule.setDestination(entity.getDestination());
        schedule.setStartTime(entity.getStartTime());
        schedule.setEndTime(entity.getEndTime());
        schedule.setDescription(entity.getDescription());
        schedule.setStatus(entity.getStatus());
        schedule.setCreatedAt(entity.getCreatedAt());
        schedule.setUpdatedAt(entity.getUpdatedAt());
        schedule.setPlate(entity.getPlate());
        schedule.setZone(entity.getZone());
        schedule.setDriverId(entity.getDriverId());
        schedule.setConditionType(entity.getConditionType());
        schedule.setVehicleType(entity.getVehicleType());
        schedule.setServiceType(entity.getServiceType());

        LOG.debug("Mapped entity to domain model: {}", schedule);
        return schedule;
    }
}
