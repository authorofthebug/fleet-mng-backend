package solutions.qowin.fleet.schedule.shared.mappers;


import solutions.qowin.fleet.schedule.domain.model.Schedule;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
      schedule.setId(""+i);
      schedule.setDescription("Descripción de la programación " + i);

      schedule.setStatus(statuses[random.nextInt(statuses.length)]);

      LocalDateTime createdAt = LocalDateTime.now().minusDays(random.nextInt(365));
      LocalDateTime updatedAt = createdAt.plusDays(random.nextInt(30));
      schedule.setCreatedAt(createdAt);
      schedule.setUpdatedAt(updatedAt);

      schedules.add(schedule);
    }
    return schedules;
  }
}