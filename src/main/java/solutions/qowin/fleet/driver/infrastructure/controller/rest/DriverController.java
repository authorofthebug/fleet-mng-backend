package solutions.qowin.fleet.driver.infrastructure.controller.rest;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import solutions.qowin.fleet.driver.application.service.DriverService;
import solutions.qowin.fleet.driver.infrastructure.controller.rest.dto.CreateDriverRequest;
import solutions.qowin.fleet.driver.infrastructure.controller.rest.dto.DriverDTO;
import solutions.qowin.fleet.driver.shared.mappers.DriverMapper;

import java.util.List;

@Controller("/api/drivers")
@Introspected
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @Post
    public HttpResponse<DriverDTO> createDriver(@Body CreateDriverRequest request) {
        return HttpResponse.created(DriverMapper.toDTO(driverService.create(DriverMapper.toDomain(request))));
    }

    @Get("/{id}")
    public HttpResponse<DriverDTO> getDriver(@PathVariable String id) {
        return HttpResponse.ok(DriverMapper.toDTO(driverService.findById(id)));
    }

    @Put("/{id}")
    public HttpResponse<DriverDTO> updateDriver(@PathVariable String id, @Body CreateDriverRequest request) {
        var driver = DriverMapper.toDomain(request);
        driver.setId(id);
        return HttpResponse.ok(DriverMapper.toDTO(driverService.update(driver)));
    }

    @Delete("/{id}")
    public HttpResponse<Void> deleteDriver(@PathVariable String id) {
        driverService.delete(id);
        return HttpResponse.noContent();
    }

    @Get
    public HttpResponse<List<DriverDTO>> getAllDrivers() {
        return HttpResponse.ok(driverService.getAll().stream().map(DriverMapper::toDTO).toList());
    }
} 