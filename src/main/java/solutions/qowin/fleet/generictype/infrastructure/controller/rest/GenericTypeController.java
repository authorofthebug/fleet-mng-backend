package solutions.qowin.fleet.generictype.infrastructure.controller.rest;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import solutions.qowin.fleet.generictype.application.service.GenericTypeService;
import solutions.qowin.fleet.generictype.infrastructure.controller.rest.dto.CreateGenericTypeRequest;
import solutions.qowin.fleet.generictype.infrastructure.controller.rest.dto.GenericTypeDTO;
import solutions.qowin.fleet.generictype.shared.mappers.GenericTypeMapper;

import java.util.List;

@Controller("/api/generic-types")
@Introspected
public class GenericTypeController {

    private final GenericTypeService genericTypeService;

    @Inject
    public GenericTypeController(GenericTypeService genericTypeService) {
        this.genericTypeService = genericTypeService;
    }

    @Post
    public HttpResponse<GenericTypeDTO> createGenericType(@Body CreateGenericTypeRequest request) {
        return HttpResponse.created(GenericTypeMapper.toDTO(genericTypeService.create(GenericTypeMapper.toDomain(request))));
    }

    @Get("/{id}")
    public HttpResponse<GenericTypeDTO> getGenericType(@PathVariable String id) {
        return HttpResponse.ok(GenericTypeMapper.toDTO(genericTypeService.findById(id)));
    }

    @Get("/{category}/{status}")
    public HttpResponse<List<GenericTypeDTO>> getGenericType(@PathVariable String category, @PathVariable String status) {

        return HttpResponse.ok(genericTypeService.getbyCategoryAndStatus(category.toUpperCase(), status.toUpperCase()).stream().map(GenericTypeMapper::toDTO).toList());
    }

    @Put("/{id}")
    public HttpResponse<GenericTypeDTO> updateGenericType(@PathVariable String id, @Body CreateGenericTypeRequest request) {
        var genericType = GenericTypeMapper.toDomain(request);
        genericType.setId(id);
        return HttpResponse.ok(GenericTypeMapper.toDTO(genericTypeService.update(genericType)));
    }

    @Delete("/{id}")
    public HttpResponse<Void> deleteGenericType(@PathVariable String id) {
        genericTypeService.delete(id);
        return HttpResponse.noContent();
    }
} 