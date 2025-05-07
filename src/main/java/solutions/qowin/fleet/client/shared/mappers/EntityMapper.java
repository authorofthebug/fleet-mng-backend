package solutions.qowin.fleet.client.shared.mappers;

import org.bson.types.ObjectId;
import solutions.qowin.fleet.client.domain.model.Client;
import solutions.qowin.fleet.client.infrastructure.persistence.documentdb.ClientDocumentDbEntity;

import java.time.LocalDateTime;

/**
 * Mapper class to convert between Client domain model and ClientDocumentDbEntity
 */
public class EntityMapper {
  /**
   * Converts a Client domain model to a ClientDocumentDbEntity
   *
   * @param client The Client domain model to convert
   * @return The corresponding ClientDocumentDbEntity
   */
  public static ClientDocumentDbEntity toEntity(Client client) {
    if (client == null) {
      return null;
    }

    ClientDocumentDbEntity entity = new ClientDocumentDbEntity();
    entity.setId(new ObjectId(client.getId()));

    // Map basic fields
    entity.setName(client.getName());
    entity.setStatus(client.getStatus());

    // Map description from notes (based on available fields in ClientDocumentDbEntity)
    entity.setDescription(client.getNotes());

    // Map code from taxId or other identifier (based on available fields)
    entity.setCode(client.getTaxId());

    // Set timestamps
    LocalDateTime now = LocalDateTime.now();
    if (client.getCreatedAt() != null) {
      entity.setCreatedAt(client.getCreatedAt());
    } else {
      entity.setCreatedAt(now);
    }

    entity.setUpdatedAt(now);

    return entity;
  }

  /**
   * Converts a ClientDocumentDbEntity to a Client domain model
   *
   * @param entity The ClientDocumentDbEntity to convert
   * @return The corresponding Client domain model
   */
  public static Client toModel(ClientDocumentDbEntity entity) {
    if (entity == null) {
      return null;
    }

    Client client = new Client();


    // Map basic fields
    client.setName(entity.getName());
    client.setStatus(entity.getStatus());

    // Map notes from description (based on available fields in ClientDocumentDbEntity)
    client.setNotes(entity.getDescription());

    // Map taxId from code (based on available fields)
    client.setTaxId(entity.getCode());

    // Set timestamps
    client.setCreatedAt(entity.getCreatedAt());
    client.setUpdatedAt(entity.getUpdatedAt());

    return client;
  }
}
