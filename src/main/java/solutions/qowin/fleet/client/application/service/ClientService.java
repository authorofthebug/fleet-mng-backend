package solutions.qowin.fleet.client.application.service;

import jakarta.inject.Singleton;
import solutions.qowin.fleet.client.domain.model.Client;
import solutions.qowin.fleet.client.port.in.ManagementClientUseCase;
import solutions.qowin.fleet.client.port.out.ClientRepository;

import java.util.List;

@Singleton
public class ClientService implements ManagementClientUseCase {
    
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        return clientRepository.update(client);
    }

    @Override
    public void delete(String id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client findById(String id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }
} 