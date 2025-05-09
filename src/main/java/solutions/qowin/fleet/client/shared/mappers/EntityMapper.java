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
    if (client.getId() != null) {
      entity.setId(new ObjectId(client.getId()));
    }
    entity.setEmail(client.getEmail());
    entity.setPhone(client.getPhone());
    entity.setAddress(client.getAddress());
    entity.setTaxId(client.getTaxId());
    entity.setName(client.getName());
    entity.setStatus(client.getStatus());
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
    if (entity.getId() != null) {
      client.setId(entity.getId().toString());
    }
    client.setTaxId(entity.getTaxId());
    client.setName(entity.getName());
    client.setEmail(entity.getEmail());
    client.setPhone(entity.getPhone());
    client.setAddress(entity.getAddress());
    client.setStatus(entity.getStatus());
    client.setCreatedAt(entity.getCreatedAt());
    client.setUpdatedAt(entity.getUpdatedAt());

    return client;
  }
}
