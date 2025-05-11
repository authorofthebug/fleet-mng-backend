package solutions.qowin.fleet.generictype.shared.mappers;

import jakarta.inject.Singleton;
import solutions.qowin.fleet.generictype.domain.model.GenericType;
import solutions.qowin.fleet.generictype.infrastructure.controller.rest.dto.CreateGenericTypeRequest;
import solutions.qowin.fleet.generictype.infrastructure.controller.rest.dto.GenericTypeDTO;

@Singleton
public class GenericTypeMapper {
    
    public static GenericType toDomain(CreateGenericTypeRequest request) {
        GenericType genericType = new GenericType();
        genericType.setName(request.getName());
        genericType.setCode(request.getCode());
        genericType.setCategory(request.getCategory());
        genericType.setDescription(request.getDescription());
        genericType.setStatus(request.getStatus());
        return genericType;
    }

    public static GenericTypeDTO toDTO(GenericType genericType) {
        GenericTypeDTO dto = new GenericTypeDTO();
        dto.setId(genericType.getId());
        dto.setName(genericType.getName());
        dto.setCode(genericType.getCode());
        dto.setCategory(genericType.getCategory());
        dto.setDescription(genericType.getDescription());
        dto.setStatus(genericType.getStatus());
        dto.setCreatedAt(genericType.getCreatedAt());
        dto.setUpdatedAt(genericType.getUpdatedAt());
        return dto;
    }
} 