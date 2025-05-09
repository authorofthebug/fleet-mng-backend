package solutions.qowin.fleet.driver.infrastructure.persistence.docdb;

import jakarta.inject.Singleton;
import org.bson.types.ObjectId;
import solutions.qowin.fleet.driver.domain.model.Driver;
import solutions.qowin.fleet.driver.port.out.DriverRepository;
import solutions.qowin.fleet.driver.shared.mappers.EntityMapper;

import java.util.List;
import java.util.Optional;

@Singleton
public class DriverRepositoryImpl implements DriverRepository {

    private final DriverDocDbRepository repository;

    public DriverRepositoryImpl(DriverDocDbRepository repository) {
        this.repository = repository;
    }

    @Override
    public Driver save(Driver driver) {
        DocDbEntity entity = EntityMapper.toEntity(driver);
        DocDbEntity savedEntity = repository.save(entity);
        return EntityMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Driver> findById(String id) {
        return repository.findById(new ObjectId(id)).map(EntityMapper::toDomain);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(new ObjectId(id));
    }

    @Override
    public List<Driver> findAll() {
        return repository.findAll().stream().map(EntityMapper::toDomain).toList();
    }
} 