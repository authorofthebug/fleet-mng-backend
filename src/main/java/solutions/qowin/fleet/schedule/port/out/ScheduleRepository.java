package solutions.qowin.fleet.schedule.port.out;


import solutions.qowin.fleet.schedule.domain.model.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {
    Schedule save(Schedule schedule);
    Optional<Schedule> findById(Long id);
    void delete(Schedule schedule);
    void deleteById(Long id);
    List<Schedule> findAll();
} 