package solutions.qowin.fleet.schedule.infrastructure.controller.rest;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import solutions.qowin.fleet.schedule.application.service.ScheduleService;
import solutions.qowin.fleet.schedule.domain.model.Schedule;
import solutions.qowin.fleet.schedule.infrastructure.controller.rest.dto.CreateScheduleRequest;
import solutions.qowin.fleet.schedule.infrastructure.controller.rest.dto.ScheduleDTO;
import solutions.qowin.fleet.schedule.shared.mappers.ScheduleMapper;

import java.util.List;


@Controller("/api/schedules")
public class ScheduleController {

  private final ScheduleService scheduleService;

  @Inject
  public ScheduleController(ScheduleService scheduleService) {
    this.scheduleService = scheduleService;
  }

  @Post
  public HttpResponse<ScheduleDTO> createSchedule(@Body CreateScheduleRequest request) {
    return HttpResponse.created(
        ScheduleMapper.toDTO(scheduleService.create(ScheduleMapper.toDomain(request))));
  }

  @Get("/{id}")
  public HttpResponse<ScheduleDTO> getSchedule(@PathVariable String id) {
    return HttpResponse.ok(ScheduleMapper.toDTO(scheduleService.findById(id)));
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
  public HttpResponse<ScheduleDTO> updateSchedule(@PathVariable String id, @Body CreateScheduleRequest request) {
    var schedule = ScheduleMapper.toDomain(request);
    schedule.setId(id);
    return HttpResponse.ok(ScheduleMapper.toDTO(scheduleService.update(schedule)));
  }

  @Delete("/{id}")
  public HttpResponse<Void> deleteSchedule(@PathVariable String id) {
    scheduleService.delete(id);
    return HttpResponse.noContent();
  }
}