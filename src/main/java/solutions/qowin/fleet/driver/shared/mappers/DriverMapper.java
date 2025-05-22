package solutions.qowin.fleet.driver.shared.mappers;

import jakarta.inject.Singleton;
import solutions.qowin.fleet.driver.domain.model.Driver;
import solutions.qowin.fleet.driver.infrastructure.controller.rest.dto.DriverDTO;
import solutions.qowin.fleet.driver.infrastructure.controller.rest.dto.CreateDriverRequest;

@Singleton
public class DriverMapper {
    
    public static Driver toDomain(CreateDriverRequest request) {
        Driver driver = new Driver();
        driver.setFirstName(request.getFirstName());
        driver.setLastName(request.getLastName());
        driver.setLicenseNumber(request.getLicenseNumber());
        driver.setLicenseExpiration(request.getLicenseExpiration());
        driver.setEmail(request.getEmail());
        driver.setPhone(request.getPhone());
        driver.setAddress(request.getAddress());
        driver.setStatus(request.getStatus());
        driver.setNotes(request.getNotes());
        driver.setCreatedAt(request.getCreatedAt());
        driver.setUpdatedAt(request.getUpdatedAt());
        driver.setRut(request.getRut());
        driver.setFolio(request.getFolio());
        driver.setDocType(request.getDocType());
        return driver;
    }

    public static DriverDTO toDTO(Driver driver) {
        DriverDTO dto = new DriverDTO();
        dto.setId(driver.getId());
        dto.setFirstName(driver.getFirstName());
        dto.setLastName(driver.getLastName());
        dto.setLicenseNumber(driver.getLicenseNumber());
        dto.setLicenseExpiration(driver.getLicenseExpiration());
        dto.setEmail(driver.getEmail());
        dto.setPhone(driver.getPhone());
        dto.setAddress(driver.getAddress());
        dto.setStatus(driver.getStatus());
        dto.setNotes(driver.getNotes());
        dto.setCreatedAt(driver.getCreatedAt());
        dto.setUpdatedAt(driver.getUpdatedAt());
        dto.setRut(driver.getRut());
        dto.setFolio(driver.getFolio());
        dto.setDocType(driver.getDocType());
        return dto;
    }
} 