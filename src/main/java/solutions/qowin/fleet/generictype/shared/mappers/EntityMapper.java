package solutions.qowin.fleet.generictype.shared.mappers;

import org.bson.types.ObjectId;
import solutions.qowin.fleet.generictype.domain.model.GenericType;
import solutions.qowin.fleet.generictype.infrastructure.persistence.docdb.RdsEntity;

public class EntityMapper {
    public static RdsEntity toEntity(GenericType genericType) {
        RdsEntity entity = new RdsEntity();
        if (genericType.getId() != null) {
            entity.setId(new ObjectId(genericType.getId()));
        }
        entity.setName(genericType.getName());
        entity.setDescription(genericType.getDescription());
        entity.setCategory(genericType.getCategory());
        entity.setStatus(genericType.getStatus());
        entity.setCode(genericType.getCode());
        entity.setCreatedAt(genericType.getCreatedAt());
        entity.setUpdatedAt(genericType.getUpdatedAt());
        return entity;
    }

    public static GenericType toDomain(RdsEntity entity) {
        GenericType genericType = new GenericType();
        if (entity.getId() != null) {
            genericType.setId(entity.getId().toString());
        }
        genericType.setName(entity.getName());
        genericType.setDescription(entity.getDescription());
        genericType.setCategory(entity.getCategory());
        genericType.setStatus(entity.getStatus());
        genericType.setCode(entity.getCode());
        genericType.setCreatedAt(entity.getCreatedAt());
        genericType.setUpdatedAt(entity.getUpdatedAt());
        return genericType;
    }
}
