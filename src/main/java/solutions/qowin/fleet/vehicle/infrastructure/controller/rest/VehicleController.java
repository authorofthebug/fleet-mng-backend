package solutions.qowin.fleet.vehicle.infrastructure.controller.rest;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import solutions.qowin.fleet.vehicle.application.service.VehicleService;
import solutions.qowin.fleet.vehicle.infrastructure.controller.rest.dto.CreateVehicleRequest;
import solutions.qowin.fleet.vehicle.infrastructure.controller.rest.dto.VehicleDTO;
import solutions.qowin.fleet.vehicle.shared.mappers.VehicleDomainMapper;

import java.util.List;

@Controller("/dev/vehicle")
@Introspected
public class VehicleController {

    private final VehicleService vehicleService;

    @Inject
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Post
    public HttpResponse<VehicleDTO> createVehicle(@Body CreateVehicleRequest request) {
        return HttpResponse.created(VehicleDomainMapper.toDTO(vehicleService.create(VehicleDomainMapper.toDomain(request))));
    }

    @Get("/{id}")
    public HttpResponse<VehicleDTO> getVehicle(@PathVariable String id) {
        return HttpResponse.ok(VehicleDomainMapper.toDTO(vehicleService.findById(id)));
    }

    @Get
    public HttpResponse<List<VehicleDTO>> getAllVehicles() {
        return HttpResponse.ok(vehicleService.getAll().stream().map(VehicleDomainMapper::toDTO).toList());
    }

    @Put("/{id}")
    public HttpResponse<VehicleDTO> updateVehicle(@PathVariable String id, @Body CreateVehicleRequest request) {
        var vehicle = VehicleDomainMapper.toDomain(request);
        vehicle.setId(id);
        return HttpResponse.ok(VehicleDomainMapper.toDTO(vehicleService.update(vehicle)));
    }

    @Delete("/{id}")
    public HttpResponse<Void> deleteVehicle(@PathVariable String id) {
        vehicleService.delete(id);
        return HttpResponse.noContent();
    }
} 