package solutions.qowin.fleet.schedule.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Driver;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Represents a schedule in the system that defines time slots for various operations.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    private Long id;

    private String code;

    private String name;

    private String description;

    private LocalTime startTime;

    private LocalTime endTime;

    private String status;

    private Driver driver;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String createdBy;

    private String updatedBy;

} 