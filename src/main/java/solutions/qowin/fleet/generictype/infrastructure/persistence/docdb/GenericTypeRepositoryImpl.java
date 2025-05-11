package solutions.qowin.fleet.generictype.infrastructure.persistence.docdb;

import jakarta.inject.Singleton;
import org.bson.types.ObjectId;
import solutions.qowin.fleet.generictype.domain.model.GenericType;
import solutions.qowin.fleet.generictype.port.out.GenericTypeRepository;
import solutions.qowin.fleet.generictype.shared.mappers.EntityMapper;

import java.util.List;
import java.util.Optional;

@Singleton
public class GenericTypeRepositoryImpl implements GenericTypeRepository {

    private final GenericTypeDocDbRepository repository;

    public GenericTypeRepositoryImpl(GenericTypeDocDbRepository repository) {
        this.repository = repository;
    }

    @Override
    public GenericType save(GenericType genericType) {
        RdsEntity savedEntity = repository.save(EntityMapper.toEntity(genericType));
        return EntityMapper.toDomain(savedEntity);
    }

    @Override
    public GenericType update(GenericType genericType) {
        RdsEntity savedEntity = repository.update(EntityMapper.toEntity(genericType));
        return EntityMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<GenericType> findById(String id) {
        return repository.findById(new ObjectId(id)).map(EntityMapper::toDomain);
    }

    @Override
    public List<GenericType> getbyCategoryAndStatus(String category, String status) {
        return repository.findByCategoryAndStatus(category, status).stream()
            .map(EntityMapper::toDomain)
            .toList();
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(new ObjectId(id));
    }
} 