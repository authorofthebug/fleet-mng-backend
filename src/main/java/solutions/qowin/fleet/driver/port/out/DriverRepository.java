package solutions.qowin.fleet.driver.port.out;

import solutions.qowin.fleet.driver.domain.model.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverRepository {
    Driver save(Driver driver);
    Driver update(Driver driver);
    Optional<Driver> findById(String id);
    void deleteById(String id);
    List<Driver> findAll();
} 