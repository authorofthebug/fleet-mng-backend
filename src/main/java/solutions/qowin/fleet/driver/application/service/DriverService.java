package solutions.qowin.fleet.driver.application.service;

import jakarta.inject.Singleton;
import solutions.qowin.fleet.driver.domain.model.Driver;
import solutions.qowin.fleet.driver.port.in.ManagementDriverUseCase;
import solutions.qowin.fleet.driver.port.out.DriverRepository;

import java.util.List;

@Singleton
public class DriverService implements ManagementDriverUseCase {
    
    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Driver create(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public Driver update(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public void delete(String id) {
        driverRepository.deleteById(id);
    }

    @Override
    public Driver findById(String id) {
        return driverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found"));
    }

    public List<Driver> getAll() {
        return driverRepository.findAll();
    }

} 