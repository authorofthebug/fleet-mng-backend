package solutions.qowin.fleet.schedule.port.out;


import solutions.qowin.fleet.schedule.domain.model.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {
    Schedule update(Schedule schedule);
    Schedule save(Schedule schedule);
    Optional<Schedule> findById(String id);
    void delete(Schedule schedule);
    void deleteById(String id);
    List<Schedule> findAll();
} 