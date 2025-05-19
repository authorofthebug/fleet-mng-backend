package solutions.qowin.fleet.client.infrastructure.controller.rest;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import solutions.qowin.fleet.client.application.service.ClientService;
import solutions.qowin.fleet.client.infrastructure.controller.rest.dto.ClientDTO;
import solutions.qowin.fleet.client.infrastructure.controller.rest.dto.CreateClientRequest;
import solutions.qowin.fleet.client.shared.mappers.ClientMapper;

import java.util.List;

@Controller("/dev/client")
@Introspected
public class ClientController {

    private final ClientService clientService;

    @Inject
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Post
    public HttpResponse<ClientDTO> createClient(@Body CreateClientRequest request) {
        return HttpResponse.created(ClientMapper.toDTO(clientService.create(ClientMapper.toDomain(request))));
    }

    @Get("/{id}")
    public HttpResponse<ClientDTO> getClient(@PathVariable String id) {
        return HttpResponse.ok(ClientMapper.toDTO(clientService.findById(id)));
    }

    @Get
    public HttpResponse<List<ClientDTO>> getAllClients() {
        return HttpResponse.ok(clientService.getAll().stream().map(ClientMapper::toDTO).toList());
    }

    @Put("/{id}")
    public HttpResponse<ClientDTO> updateClient(@PathVariable String id, @Body CreateClientRequest request) {
        var client = ClientMapper.toDomain(request);
        client.setId(id);
        return HttpResponse.ok(ClientMapper.toDTO(clientService.update(client)));
    }

    @Delete("/{id}")
    public HttpResponse<Void> deleteClient(@PathVariable String id) {
        clientService.delete(id);
        return HttpResponse.noContent();
    }
} 