package solutions.qowin.fleet.vehicle.infrastructure.persistence.documentdb;

import jakarta.inject.Singleton;
import org.bson.types.ObjectId;
import solutions.qowin.fleet.vehicle.domain.model.Vehicle;
import solutions.qowin.fleet.vehicle.port.out.VehicleRepository;
import solutions.qowin.fleet.vehicle.shared.mappers.VehicleEntityMapper;

import java.util.List;
import java.util.Optional;

@Singleton
public class VehicleRepositoryImpl implements VehicleRepository {

    private final VehicleDocDbRepository repository;

    public VehicleRepositoryImpl(VehicleDocDbRepository repository) {
        this.repository = repository;
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        VehicleDocDbEntity entity = VehicleEntityMapper.toEntity(vehicle);
        VehicleDocDbEntity savedEntity = repository.save(entity);
        return VehicleEntityMapper.toDomain(savedEntity);

    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        VehicleDocDbEntity entity = VehicleEntityMapper.toEntity(vehicle);
        VehicleDocDbEntity savedEntity = repository.update(entity);
        return VehicleEntityMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Vehicle> findById(String id) {
        return repository.findById(new ObjectId(id)).map(VehicleEntityMapper::toDomain);
    }

    @Override
    public void delete(Vehicle vehicle) {
        repository.delete(VehicleEntityMapper.toEntity(vehicle));
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(new ObjectId(id));
    }

    @Override
    public List<Vehicle> findAll() {
        return repository.findAll().stream().map(VehicleEntityMapper::toDomain).toList();
    }
} 