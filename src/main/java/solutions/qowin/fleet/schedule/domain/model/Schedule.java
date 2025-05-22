package solutions.qowin.fleet.schedule.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Represents a schedule in the system that defines time slots for various operations.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    private String id;
    private String description;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String clientId;
    private String vehicleId;
    private String driverId;
    private String origin;
    private String plate;
    private String zone;
    private String destination;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String serviceType;
    private String conditionType;
    private String vehicleType;
}