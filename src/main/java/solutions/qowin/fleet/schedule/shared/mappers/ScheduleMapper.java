package solutions.qowin.fleet.schedule.shared.mappers;

import jakarta.inject.Singleton;
import solutions.qowin.fleet.schedule.domain.model.Schedule;
import solutions.qowin.fleet.schedule.infrastructure.controller.rest.dto.CreateScheduleRequest;
import solutions.qowin.fleet.schedule.infrastructure.controller.rest.dto.ScheduleDTO;

import java.time.LocalDateTime;

@Singleton
public class ScheduleMapper {

    public static Schedule toDomain(CreateScheduleRequest request) {
        Schedule schedule = new Schedule();
        schedule.setName(request.getTitle());
        schedule.setDescription(request.getDescription());

        if (request.getStartTime() != null) {
            schedule.setStartTime(request.getStartTime().toLocalTime());
        }

        if (request.getEndTime() != null) {
            schedule.setEndTime(request.getEndTime().toLocalTime());
        }

        schedule.setStatus(request.getStatus());
        schedule.setCode(request.getLocation());
        return schedule;
    }

    public static ScheduleDTO toDTO(Schedule schedule) {
        if (schedule == null) return null;

        ScheduleDTO dto = new ScheduleDTO();
        //dto.setId(schedule.getId());
        dto.setTitle(schedule.getName());
        dto.setDescription(schedule.getDescription());

        // Preservar la fecha original usando la fecha de creación
        if (schedule.getStartTime() != null && schedule.getCreatedAt() != null) {
            LocalDateTime startDateTime = schedule.getCreatedAt()
                .withHour(schedule.getStartTime().getHour())
                .withMinute(schedule.getStartTime().getMinute())
                .withSecond(schedule.getStartTime().getSecond());
            //dto.setStartTime(startDateTime);
        }

        if (schedule.getEndTime() != null && schedule.getCreatedAt() != null) {
            LocalDateTime endDateTime = schedule.getCreatedAt()
                .withHour(schedule.getEndTime().getHour())
                .withMinute(schedule.getEndTime().getMinute())
                .withSecond(schedule.getEndTime().getSecond());
           // dto.setEndTime(endDateTime);
        }

        //dto.setStatus(schedule.getStatus());
        //dto.setLocation(schedule.getCode());
        //dto.setCreatedAt(schedule.getCreatedAt());
        //dto.setUpdatedAt(schedule.getUpdatedAt());
        return dto;
    }
}