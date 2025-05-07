package solutions.qowin.fleet.schedule.infrastructure.controller.rest.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Request object for creating a new schedule
 */
@Data
@Introspected
@Serdeable
@NoArgsConstructor
@AllArgsConstructor
public class CreateScheduleRequest {
    private String title;
    private String origin;
    private String destination;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;
    private String location;
    //Objeto cliente
    //Tipo de servicio por empresa y ACTIVO
    // Tipo de condicion

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}