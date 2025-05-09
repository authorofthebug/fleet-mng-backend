package solutions.qowin.fleet.driver.port.in;

import solutions.qowin.fleet.driver.domain.model.Driver;

import java.util.List;

public interface ManagementDriverUseCase {
    Driver create(Driver driver);
    Driver update(Driver driver);
    void delete(String id);
    Driver findById(String id);
    List<Driver> getAll();
} 