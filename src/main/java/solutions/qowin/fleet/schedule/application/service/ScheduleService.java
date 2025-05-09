package solutions.qowin.fleet.schedule.application.service;

import jakarta.inject.Singleton;
import solutions.qowin.fleet.schedule.domain.model.Schedule;
import solutions.qowin.fleet.schedule.port.in.ManagementScheduleUseCase;
import solutions.qowin.fleet.schedule.port.out.ScheduleRepository;
import solutions.qowin.fleet.schedule.shared.mappers.ScheduleUtils;

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
        List<Schedule> schedules = scheduleRepository.findAll();

        // If no schedules exist, generate and save some random ones
        if (schedules.isEmpty()) {
            System.out.println("No schedules found, generating random ones");
            List<Schedule> randomSchedules = ScheduleUtils.generateRandomSchedules(10);
            System.out.println("Generated " + randomSchedules.size() + " random schedules");
            for (Schedule schedule : randomSchedules) {
                System.out.println("Saving schedule: " + schedule.getId());
                scheduleRepository.save(schedule);
            }
            return randomSchedules;
        }

        System.out.println("Found " + schedules.size() + " schedules in repository");
        return schedules;
    }

    public Schedule findById(String id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
    }
}