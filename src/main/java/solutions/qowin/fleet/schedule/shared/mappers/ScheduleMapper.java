package solutions.qowin.fleet.schedule.shared.mappers;

import jakarta.inject.Singleton;
import solutions.qowin.fleet.schedule.domain.model.Schedule;
import solutions.qowin.fleet.schedule.infrastructure.controller.rest.dto.CreateScheduleRequest;
import solutions.qowin.fleet.schedule.infrastructure.controller.rest.dto.ScheduleDTO;

@Singleton
public class ScheduleMapper {

    public static Schedule toDomain(CreateScheduleRequest request) {
        Schedule schedule = new Schedule();
        schedule.setDescription(request.getDescription());
        schedule.setStartTime(request.getStartTime());
        schedule.setEndTime(request.getEndTime());
        schedule.setStatus(request.getStatus());
        schedule.setCreatedAt(request.getCreatedAt());
        schedule.setUpdatedAt(request.getUpdatedAt());
        schedule.setVehicleId(request.getVehicleId());
        schedule.setClientId(request.getClientId());
        schedule.setOrigin(request.getOrigin());
        schedule.setDestination(request.getDestination());
        schedule.setPlate(request.getPlate());
        schedule.setZone(request.getZone());
        schedule.setDriverId(request.getDriverId());

        return schedule;
    }

    public static ScheduleDTO toDTO(Schedule schedule) {
        ScheduleDTO dto = new ScheduleDTO();
        dto.setId(schedule.getId());
        dto.setDescription(schedule.getDescription());
        dto.setStartTime(schedule.getStartTime());
        dto.setEndTime(schedule.getEndTime());
        dto.setStatus(schedule.getStatus());
        dto.setCreatedAt(schedule.getCreatedAt());
        dto.setUpdatedAt(schedule.getUpdatedAt());
        dto.setVehicleId(schedule.getVehicleId());
        dto.setClientId(schedule.getClientId());
        dto.setOrigin(schedule.getOrigin());
        dto.setDestination(schedule.getDestination());
        dto.setPlate(schedule.getPlate());
        dto.setZone(schedule.getZone());
        dto.setDriverId(schedule.getDriverId());
        return dto;
    }
}