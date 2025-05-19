package solutions.qowin.fleet.vehicle.shared.mappers;

import org.bson.types.ObjectId;
import solutions.qowin.fleet.vehicle.domain.model.Vehicle;
import solutions.qowin.fleet.vehicle.infrastructure.persistence.documentdb.VehicleDocDbEntity;

public class VehicleEntityMapper {
    public static VehicleDocDbEntity toEntity(Vehicle vehicle) {
        VehicleDocDbEntity entity = new VehicleDocDbEntity();
        if (vehicle.getId() != null) {
            entity.setId(new ObjectId(vehicle.getId()));
        } else {
            entity.setId(new ObjectId());
        }
        entity.setLicensePlate(vehicle.getLicensePlate());
        entity.setBrand(vehicle.getBrand());
        entity.setModel(vehicle.getModel());
        entity.setYear(vehicle.getYear());
        entity.setColor(vehicle.getColor());
        entity.setStatus(vehicle.getStatus());
        entity.setNotes(vehicle.getNotes());
        entity.setCreatedAt(vehicle.getCreatedAt());
        entity.setUpdatedAt(vehicle.getUpdatedAt());
        return entity;
    }

    public static Vehicle toDomain(VehicleDocDbEntity entity) {
        Vehicle vehicle = new Vehicle();
        if (entity.getId() != null) {
            vehicle.setId(entity.getId().toString());
        }
        vehicle.setLicensePlate(entity.getLicensePlate());
        vehicle.setBrand(entity.getBrand());
        vehicle.setModel(entity.getModel());
        vehicle.setYear(entity.getYear());
        vehicle.setColor(entity.getColor());
        vehicle.setStatus(entity.getStatus());
        vehicle.setNotes(entity.getNotes());
        vehicle.setCreatedAt(entity.getCreatedAt());
        vehicle.setUpdatedAt(entity.getUpdatedAt());
        return vehicle;
    }
}
