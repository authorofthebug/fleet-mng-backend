package solutions.qowin.fleet.vehicle.port.out;

import solutions.qowin.fleet.vehicle.domain.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository {
    Vehicle save(Vehicle vehicle);
    Vehicle update(Vehicle vehicle);
    Optional<Vehicle> findById(String id);
    void delete(Vehicle vehicle);
    void deleteById(String id);
    List<Vehicle> findAll();
} 