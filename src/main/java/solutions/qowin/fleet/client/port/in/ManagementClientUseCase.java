package solutions.qowin.fleet.client.port.in;


import solutions.qowin.fleet.client.domain.model.Client;

import java.util.List;

public interface ManagementClientUseCase {
    Client create(Client client);
    Client update(Client client);
    void delete(String id);
    Client findById(String id);
    List<Client> getAll();
} 