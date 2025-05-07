package solutions.qowin.fleet.schedule.shared.mappers;


import solutions.qowin.fleet.schedule.domain.model.Schedule;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.time.LocalDateTime;

public class ScheduleUtils {

  public static List<Schedule> generateRandomSchedules(int count) {
    List<Schedule> schedules = new ArrayList<>();
    String[] statuses = {
        "AVAILABLE", "ON_SERVICE", "IN_MAINTENANCE", "WITH_ISSUE",
        "PROGRAM", "ON_ARRIVE", "ONGOING", "ON_CLIENT", "COME_BACK"
    };

    Random random = new Random();

    for (long i = 1; i <= count; i++) {
      Schedule schedule = new Schedule();
      schedule.setId(i);
      schedule.setName("Schedule " + i);  // Usar setName en lugar de setTitle
      schedule.setDescription("Descripción de la programación " + i);

      // Usar LocalTime para las horas
      schedule.setStartTime(LocalTime.of(6 + random.nextInt(5), random.nextInt(60)));
      schedule.setEndTime(LocalTime.of(15 + random.nextInt(6), random.nextInt(60)));

      schedule.setStatus(statuses[random.nextInt(statuses.length)]);
      schedule.setCode("Location " + i);  // Usar setCode en lugar de setLocation

      LocalDateTime createdAt = LocalDateTime.now().minusDays(random.nextInt(365));
      LocalDateTime updatedAt = createdAt.plusDays(random.nextInt(30));
      schedule.setCreatedAt(createdAt);
      schedule.setUpdatedAt(updatedAt);

      schedules.add(schedule);
    }
    return schedules;
  }
}