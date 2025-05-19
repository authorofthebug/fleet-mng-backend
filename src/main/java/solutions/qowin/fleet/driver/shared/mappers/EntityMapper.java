package solutions.qowin.fleet.driver.shared.mappers;

import org.bson.types.ObjectId;
import solutions.qowin.fleet.driver.domain.model.Driver;
import solutions.qowin.fleet.driver.infrastructure.persistence.docdb.DocDbEntity;

public class EntityMapper {
    public static DocDbEntity toEntity(Driver driver) {
        DocDbEntity entity = new DocDbEntity();
        if (driver.getId() != null) {
            entity.setId(new ObjectId(driver.getId()));
        }else {
            entity.setId(new ObjectId());
        }
        entity.setFirstName(driver.getFirstName());
        entity.setLastName(driver.getLastName());
        entity.setEmail(driver.getEmail());
        entity.setPhone(driver.getPhone());
        entity.setLicenseNumber(driver.getLicenseNumber());
        entity.setLicenseExpiration(driver.getLicenseExpiration());
        entity.setAddress(driver.getAddress());
        entity.setStatus(driver.getStatus());
        entity.setNotes(driver.getNotes());
        entity.setCreatedAt(driver.getCreatedAt());
        entity.setUpdatedAt(driver.getUpdatedAt());
        return entity;
    }

    public static Driver toDomain(DocDbEntity entity) {
        Driver driver = new Driver();
        if (entity.getId() != null) {
            driver.setId(entity.getId().toString());
        }
        driver.setFirstName(entity.getFirstName());
        driver.setLastName(entity.getLastName());
        driver.setEmail(entity.getEmail());
        driver.setPhone(entity.getPhone());
        driver.setLicenseNumber(entity.getLicenseNumber());
        driver.setLicenseExpiration(entity.getLicenseExpiration());
        driver.setAddress(entity.getAddress());
        driver.setStatus(entity.getStatus());
        driver.setNotes(entity.getNotes());
        driver.setCreatedAt(entity.getCreatedAt());
        driver.setUpdatedAt(entity.getUpdatedAt());
        return driver;
    }
}
