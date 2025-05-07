package solutions.qowin.fleet.schedule.infrastructure.controller.rest;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import solutions.qowin.fleet.schedule.application.service.ScheduleService;
import solutions.qowin.fleet.schedule.domain.model.Schedule;
import solutions.qowin.fleet.schedule.infrastructure.controller.rest.dto.CreateScheduleRequest;
import solutions.qowin.fleet.schedule.infrastructure.controller.rest.dto.ScheduleDTO;
import solutions.qowin.fleet.schedule.shared.mappers.ScheduleMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller("/api/schedules")
public class ScheduleController {

  private final ScheduleService scheduleService;
  private final ScheduleMapper scheduleMapper;

  @Inject
  public ScheduleController(ScheduleService scheduleService, ScheduleMapper scheduleMapper) {
    this.scheduleService = scheduleService;
    this.scheduleMapper = scheduleMapper;
  }

  @Post
  public HttpResponse<ScheduleDTO> createSchedule(@Body CreateScheduleRequest request) {
    return HttpResponse.created(scheduleMapper.toDTO(scheduleService.create(scheduleMapper.toDomain(request))));
  }

  @Get("/{id}")
  public HttpResponse<ScheduleDTO> getSchedule(@PathVariable Long id) {
    return HttpResponse.ok(scheduleMapper.toDTO(scheduleService.findById(id)));
  }

  @Get
  public HttpResponse<List<ScheduleDTO>> getSchedules() {
    List<Schedule> schedules = scheduleService.getAll();
    List<ScheduleDTO> dtos = schedules.stream()
        .map(ScheduleMapper::toDTO)
        .toList();

    return HttpResponse.ok(dtos)
        .contentType(MediaType.APPLICATION_JSON_TYPE);
  }

  @Put("/{id}")
  public HttpResponse<ScheduleDTO> updateSchedule(@PathVariable Long id, @Body CreateScheduleRequest request) {
    var schedule = scheduleMapper.toDomain(request);
    schedule.setId(id);
    return HttpResponse.ok(scheduleMapper.toDTO(scheduleService.getAll().get(0)));
  }

  @Delete("/{id}")
  public HttpResponse<Void> deleteSchedule(@PathVariable Long id) {
    scheduleService.delete(id);
    return HttpResponse.noContent();
  }
}