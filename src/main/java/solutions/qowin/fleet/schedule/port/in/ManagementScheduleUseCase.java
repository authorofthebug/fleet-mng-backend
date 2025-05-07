package solutions.qowin.fleet.schedule.port.in;


import solutions.qowin.fleet.schedule.domain.model.Schedule;

import java.util.List;

public interface ManagementScheduleUseCase {
    Schedule create(Schedule schedule);
    Schedule update(Schedule schedule);
    void delete(String id);
    List<Schedule> getAll();
} 