package solutions.qowin.fleet.vehicle.shared.mappers;

import jakarta.inject.Singleton;
import solutions.qowin.fleet.vehicle.domain.model.Vehicle;
import solutions.qowin.fleet.vehicle.infrastructure.controller.rest.dto.CreateVehicleRequest;
import solutions.qowin.fleet.vehicle.infrastructure.controller.rest.dto.VehicleDTO;

@Singleton
public class VehicleDomainMapper {
    
    public static Vehicle toDomain(CreateVehicleRequest request) {
        Vehicle vehicle = new Vehicle();
        vehicle.setLicensePlate(request.getLicensePlate());
        vehicle.setBrand(request.getBrand());
        vehicle.setModel(request.getModel());
        vehicle.setYear(request.getYear());
        vehicle.setColor(request.getColor());
        vehicle.setStatus(request.getStatus());
        vehicle.setNotes(request.getNotes());
        return vehicle;
    }

    public static VehicleDTO toDTO(Vehicle vehicle) {
        VehicleDTO dto = new VehicleDTO();
        dto.setId(vehicle.getId());
        dto.setLicensePlate(vehicle.getLicensePlate());
        dto.setBrand(vehicle.getBrand());
        dto.setModel(vehicle.getModel());
        dto.setYear(vehicle.getYear());
        dto.setColor(vehicle.getColor());
        dto.setStatus(vehicle.getStatus());
        dto.setNotes(vehicle.getNotes());
        dto.setCreatedAt(vehicle.getCreatedAt());
        dto.setUpdatedAt(vehicle.getUpdatedAt());
        return dto;
    }
} 