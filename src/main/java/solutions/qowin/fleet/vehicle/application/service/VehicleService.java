package solutions.qowin.fleet.vehicle.application.service;

import jakarta.inject.Singleton;
import solutions.qowin.fleet.vehicle.domain.model.Vehicle;
import solutions.qowin.fleet.vehicle.port.in.ManagementVehicleUseCase;
import solutions.qowin.fleet.vehicle.port.out.VehicleRepository;

import java.util.List;

@Singleton
public class VehicleService implements ManagementVehicleUseCase {
    
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        return vehicleRepository.update(vehicle);
    }

    @Override
    public void delete(String id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public Vehicle findById(String id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }
} 