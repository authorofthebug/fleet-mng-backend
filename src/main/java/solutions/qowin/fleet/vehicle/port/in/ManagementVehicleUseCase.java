package solutions.qowin.fleet.vehicle.port.in;

import solutions.qowin.fleet.vehicle.domain.model.Vehicle;

import java.util.List;

public interface ManagementVehicleUseCase {
    Vehicle create(Vehicle vehicle);
    Vehicle update(Vehicle vehicle);
    void delete(String id);
    Vehicle findById(String id);
    List<Vehicle> getAll();
} 