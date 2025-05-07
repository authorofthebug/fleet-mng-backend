package solutions.qowin.fleet.client.infrastructure.persistence.documentdb;

import jakarta.inject.Singleton;
import org.bson.types.ObjectId;
import solutions.qowin.fleet.client.domain.model.Client;
import solutions.qowin.fleet.client.port.out.ClientRepository;
import solutions.qowin.fleet.client.shared.mappers.EntityMapper;

import java.util.List;
import java.util.Optional;

@Singleton
public class Adapter implements ClientRepository {

private final ClientDocumentDbRepository repository;

    public Adapter(ClientDocumentDbRepository repository) {
        this.repository = repository;
    }

    @Override
    public Client save(Client client) {
        ClientDocumentDbEntity entity = EntityMapper.toEntity(client);
        ClientDocumentDbEntity savedEntity = repository.save(entity);
        return EntityMapper.toModel(savedEntity);
    }

    @Override
    public Client update(Client client) {
        ClientDocumentDbEntity entity = EntityMapper.toEntity(client);
        ClientDocumentDbEntity savedEntity = repository.update(entity);
        return EntityMapper.toModel(savedEntity);
    }

    @Override
    public Optional<Client> findById(String id) {
        return repository.findById(new ObjectId(id)).map(EntityMapper::toModel);
    }

    @Override
    public void delete(ClientDocumentDbEntity client) {
        repository.delete(client);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(new ObjectId(id));
    }

    @Override
    public List<Client> findAll() {
        return repository.findAll().stream().map(EntityMapper::toModel).toList();
    }
} 