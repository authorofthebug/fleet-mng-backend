package solutions.qowin.fleet.client.port.out;


import solutions.qowin.fleet.client.domain.model.Client;
import solutions.qowin.fleet.client.infrastructure.persistence.documentdb.ClientDocumentDbEntity;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    Client save(Client client);
    Client update(Client client);
    Optional<Client> findById(String id);
    void delete(ClientDocumentDbEntity client);
    void deleteById(String id);
    List<Client> findAll();
} 