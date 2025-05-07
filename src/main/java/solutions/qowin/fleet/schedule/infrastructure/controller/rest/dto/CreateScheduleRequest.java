package solutions.qowin.fleet.schedule.infrastructure.controller.rest.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Request object for creating a new schedule
 */
@Data
@Introspected
@Serdeable
public class CreateScheduleRequest {
    private String title;

    private String description;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String status;

    private String location;
}