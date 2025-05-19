package solutions.qowin.fleet.schedule.application.service;

import jakarta.inject.Singleton;
import solutions.qowin.fleet.schedule.domain.model.Schedule;
import solutions.qowin.fleet.schedule.port.in.ManagementScheduleUseCase;
import solutions.qowin.fleet.schedule.port.out.ScheduleRepository;

import java.util.List;

@Singleton
public class ScheduleService implements ManagementScheduleUseCase {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Schedule create(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule update(Schedule schedule) {
        return scheduleRepository.update(schedule);
    }

    @Override
    public void delete(String id) {
        scheduleRepository.deleteById(id);
    }

    @Override
    public List<Schedule> getAll() {
        // Get all schedules from the repository
        return scheduleRepository.findAll();

    }

    public Schedule findById(String id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
    }
}