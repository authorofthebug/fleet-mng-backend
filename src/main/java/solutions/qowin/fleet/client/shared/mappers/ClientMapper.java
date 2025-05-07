package solutions.qowin.fleet.client.shared.mappers;

import jakarta.inject.Singleton;
import solutions.qowin.fleet.client.domain.model.Client;
import solutions.qowin.fleet.client.infrastructure.controller.rest.dto.ClientDTO;
import solutions.qowin.fleet.client.infrastructure.controller.rest.dto.CreateClientRequest;

@Singleton
public class ClientMapper {
    
    public static Client toDomain(CreateClientRequest request) {
        Client client = new Client();
        client.setName(request.getName());
        client.setEmail(request.getEmail());
        client.setPhone(request.getPhone());
        client.setAddress(request.getAddress());
        client.setTaxId(request.getTaxId());
        client.setStatus(request.getStatus());
        client.setNotes(request.getNotes());
        return client;
    }

    public static ClientDTO toDTO(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setName(client.getName());
        dto.setEmail(client.getEmail());
        dto.setPhone(client.getPhone());
        dto.setAddress(client.getAddress());
        dto.setTaxId(client.getTaxId());
        dto.setStatus(client.getStatus());
        dto.setNotes(client.getNotes());
        dto.setCreatedAt(client.getCreatedAt());
        dto.setUpdatedAt(client.getUpdatedAt());
        return dto;
    }
} 