package solutions.qowin.fleet.schedule.infrastructure.persistence.documentdb;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import lombok.Data;
import org.bson.types.ObjectId;

@Data
@MappedEntity("schedules")
public class DocumentDbEntity {
    @Id
    private ObjectId id;

    // Add other fields as needed
    private String code;
    private String name;
    private String description;
    private String status;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}